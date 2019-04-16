package cn.lyf.staticresourceserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String password;
    private String role;
    //private List<GrantedAuthority> grantedAuthorities;

}
