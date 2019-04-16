package cn.lyf.oauthserver.security;/**
 * @Title: $file_name
 * @Package $package_name
 * @Description: $todo(用一句话描述该文件做什么)
 * @author DIC.$user
 * @date $date$ $time
 * @version V1.0
 */

import cn.lyf.oauthserver.entity.UserEntity;
import cn.lyf.oauthserver.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author DIC.sweetlfy
 * @version V1.0
 * @Title: MyUserDetailsService
 * @Package cn.lyf.oauthserver.security
 * @Description: (用一句话描述该文件做什么)
 * @date 2018/11/14 11:53
 */
@Slf4j
@Component
public class MyUserDetailsService implements UserDetailsService {
    @Resource
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userName);
        try {
            userEntity = userService.login(userEntity);
        } catch (NullPointerException e) {
            log.error("用户信息异常", e);
            throw new UsernameNotFoundException("****用户不存在****");
        }
        return new SecurityUser(userEntity);
    }
}
