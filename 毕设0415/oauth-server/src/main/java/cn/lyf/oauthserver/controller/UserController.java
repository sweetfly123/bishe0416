package cn.lyf.oauthserver.controller;

import cn.lyf.oauthserver.entity.UserEntity;
import cn.lyf.oauthserver.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * @Title: UserController
 * @Package cn.lyf.oauthserver.controller
 * @Description: (用一句话描述该文件做什么)
 * @author DIC.sweetlfy
 * @date 2018/11/14 14:43
 * @version V1.0
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Resource
    private UserService userService;
    @GetMapping("/user")
    public Principal user(Principal user){
        Principal a= user;
        return a;
    }

    /**
     * @method  regist
     * @Param:  userName password
     * @Description: (用一句话描述该文件做什么)
     * @author DIC.sweetlfy
     * @date 2018/11/15 15:43
     * @version V1.0
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public void register(String userName,String password){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userName);
        userEntity.setPassword(new BCryptPasswordEncoder().encode(password));
        userService.register(userEntity);
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public UserEntity login(@PathVariable("userName") String userName){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userName);
        return userService.login(userEntity);
    }
}
