package cn.lyf.staticresourceserver.controller;

import cn.lyf.staticresourceserver.entity.UserDO;
import cn.lyf.staticresourceserver.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * @author DIC.sweetlfy
 * @version V1.0
 * @Title: UserController
 * @Package cn.lyf.staticresourceserver.controller
 * @Description: (用一句话描述该文件做什么)
 * @date 2018/11/16 14:50
 */
@RestController
@PreAuthorize("hasAuthority('user')")
public class UserController {
    @Resource
    private UserService userService;

    @Value("${spring.mvc.static-path-pattern}")
    private String hello;

    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    /**
     * @method regist
     * @Param: * @param userName* @param password
     * @Description: (用一句话描述该文件做什么)
     * @author DIC.sweetlfy
     * @date 2018/11/15 15:43
     * @version V1.0
     */
    @PostMapping("/user/register")
    public void register(String userName, String password) {
        UserDO userDO = new UserDO();
        userDO.setUserName(userName);
        userDO.setPassword(new BCryptPasswordEncoder().encode(password));
        userService.register(userDO);
    }

    /**
     * @param userName
     * @method: login
     * @Description: (用一句话描述该文件做什么)
     * @author: DIC.sweetlfy
     * @date: 2018/11/15 17:13
     * @Return: cn.lyf.oauthserver.entity.UserDO
     * @version: V1.0
     */
    @PostMapping("/user/login")
    public UserDO login(String userName, String password) {
        UserDO userDO = new UserDO();
        userDO.setUserName(userName);
        userDO = userService.login(userName);
        return userDO;
    }
}
