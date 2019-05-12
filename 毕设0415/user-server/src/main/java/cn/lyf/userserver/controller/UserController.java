package cn.lyf.userserver.controller;

import cn.lyf.userserver.entity.UserDO;
import cn.lyf.userserver.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * @author DIC.sweetlfy
 * @version V1.0
 * @Title: UserController
 * @Package cn.lyf.oauthserver.controller
 * @Description: (用一句话描述该文件做什么)
 * @date 2018/11/14 14:43
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Resource
    private UserService userService;
/*
    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }*/

    /**
     * @method register
     * @Param: userName password
     * @Description: (用一句话描述该文件做什么)
     * @author DIC.sweetlfy
     * @date 2018/11/15 15:43
     * @version V1.0
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void regist(String userName, String email, String password, String role) {
        UserDO userDO = new UserDO();
        userDO.setUserName(userName);
        userDO.setPassword(new BCryptPasswordEncoder().encode(password));
        userDO.setEmail(email);
        if (role == "" || role == null){
            userDO.setRole("2");
        }else {
            userDO.setRole(role);
        }
        userService.register(userDO);
    }

    /**
     * @method: login
     * @param userName
     * @Description: (用一句话描述该文件做什么)
     * @author: DIC.sweetlfy
     * @date: 2018/11/15 17:13
     * @Return: cn.lyf.oauthserver.entity.UserDO
     * @version: V1.0
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UserDO login(@RequestParam("userName") String userName) {
        UserDO userDO = new UserDO();
        userDO.setUserName(userName);
        userDO = userService.login(userDO);
        return userDO;
    }
}
