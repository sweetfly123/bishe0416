package cn.lyf.oauthserver.security;

import cn.lyf.oauthserver.entity.UserEntity;
import cn.lyf.oauthserver.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Title: SecurityUser
 * @Package cn.lyf.oauthserver.security
 * @Description: (用一句话描述该文件做什么)
 * @author DIC.sweetlfy
 * @date 2018/11/14 12:01 
 * @version V1.0
 */
//使用@Slf4j以后，默认的Slf4j对象就是log，所以使用时候可以直接log.info()、log.error()……，你需要引入
// 相当于 private static final Logger log = LoggerFactory.getLogger(SecurityUser.class);
@Slf4j
public class SecurityUser implements UserDetails,CredentialsContainer {

    private UserEntity userEntity;
    private String userName;
    private String password;

    public SecurityUser(UserEntity myEntity){
        if (myEntity!=null)
        {
            this.userEntity = myEntity;
            this.userName = myEntity.getUserName();
            this.password = myEntity.getPassword();
        }
    }

    @Override
    public void eraseCredentials() {
        this.password = null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        log.info("*************权限角色获取开始*************");
        UserService userService =  (UserService)SpringContextUtils.getBean(UserService.class);
        //UserService userService = new UserServiceImpl();
        List<String> list = userService.getAuthorities(this.userName);
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String authoritity : list){
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(authoritity);
            authorities.add(authority);
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public UserEntity getUserEntity() {
        return userEntity;
    }

}
