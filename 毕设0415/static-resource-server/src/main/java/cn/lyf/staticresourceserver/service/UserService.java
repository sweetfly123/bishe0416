package cn.lyf.staticresourceserver.service;

import cn.lyf.staticresourceserver.config.FeignConfiguration;
import cn.lyf.staticresourceserver.entity.UserDO;
import cn.lyf.staticresourceserver.service.Impl.UserServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


/**
 * @author DIC.$user
 * @version V1.0
 * @Title: $file_name
 * @Package $package_name
 * @Description: $todo(用一句话描述该文件做什么)
 * @date $date$ $time
 */
@FeignClient(name = "user-server",fallback = UserServiceImpl.class)
public interface UserService {
    /**
     * @method register
     * @param userDO
     * @Description: (用一句话描述该文件做什么)
     * @author DIC.sweetlfy
     * @date 2018/11/15 17:04
     * @Return int
     * @version V1.0
     */
    @RequestMapping(value = "/users/register", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    int register(UserDO userDO);

    /**
     * @param userName
     * @method: login
     * @Description: (用一句话描述该文件做什么)
     * @author: DIC.sweetlfy
     * @date: 2018/11/15 17:13
     * @Return: cn.lyf.oauthserver.entity.UserDO
     * @version: V1.0
     */
    @RequestMapping(value = "/users/login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    UserDO login(@RequestParam("userName") String userName);
}
