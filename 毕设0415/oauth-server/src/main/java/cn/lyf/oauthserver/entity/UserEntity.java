package cn.lyf.oauthserver.entity;/**
 * @Title: $file_name
 * @Package $package_name
 * @Description: $todo(用一句话描述该文件做什么)
 * @author DIC.$user
 * @date $date$ $time
 * @version V1.0
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * @Title: UserEntity
 * @Package cn.lyf.oauthserver.entity
 * @Description: (用一句话描述该文件做什么)
 * @author DIC.sweetlfy
 * @date 2018/11/14 10:26 
 * @version V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户角色
     */
    private String role;
    /**
     * 用户权限
     */
    private List<GrantedAuthority> grantedAuthorities;
}
