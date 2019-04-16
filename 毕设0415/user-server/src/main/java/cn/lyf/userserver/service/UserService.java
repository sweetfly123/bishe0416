package cn.lyf.userserver.service;


import cn.lyf.userserver.entity.UserDO;

import java.util.List;

public interface UserService {
    /**
     * @method: login
     * @Param:  * @param userDO
     * @Description: (用一句话描述该文件做什么)
     * @author: DIC.sweetlfy
     * @date: 2018/11/15 17:13
     * @Return: cn.lyf.oauthserver.entity.UserDO
     * @version: V1.0
     */
    UserDO login(UserDO userDO);
    /**
     * @method  register
     * @Param:  * @param userDO
     * @Description: (用一句话描述该文件做什么)
     * @author DIC.sweetlfy
     * @date 2018/11/15 17:04
     * @Return int
     * @version V1.0
     */
    int register(UserDO userDO);
    /**
     * @method: getAuthorities
     * @Param:  * @param username
     * @Description: (用一句话描述该文件做什么)
     * @author: DIC.sweetlfy
     * @date: 2018/11/15 17:19
     * @Return: java.util.List
     * @version: V1.0
     */
    List<String> getAuthorities(String userName);
}
