package cn.lyf.userserver.entity;/**
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

import java.util.List;

/**
 * @Title: UserDO
 * @Package cn.lyf.oauthserver.entity
 * @Description: (用一句话描述该文件做什么)
 * @author DIC.sweetlfy
 * @date 2018/11/14 10:26 
 * @version V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDO {
    private String userId;
    private String userName;
    private String email;
    private String password;
    private String role;
    private List<String> grantedAuthorities;
}
