package cn.lyf.hotelserver.util;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
/**
 * @Title: AuthenticationUtil
 * @Description: 获取token中存储的用户信息
 * @author: DIC.lyf
 * @date: 2018/12/7 11:46
 * @Return:
 * @version: V1.0
 */
public class AuthenticationUtil {
    public static String getUserName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = null;
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }
        return currentUserName;
    }
}
