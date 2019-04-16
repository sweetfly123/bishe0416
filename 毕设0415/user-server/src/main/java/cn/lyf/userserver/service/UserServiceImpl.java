package cn.lyf.userserver.service;
import cn.lyf.userserver.dao.UserDao;
import cn.lyf.userserver.entity.UserDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Title  UserServiceImpl
 * @Description: User接口实现类
 * @author DIC.sweetlfy
 * @date 2018/11/15 16:39
 * @version V1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    /**
     * @method: login
     * @Param:  * @param userDO
     * @Description: (用一句话描述该文件做什么)
     * @author: DIC.sweetlfy
     * @date: 2018/11/15 17:14
     * @Return: cn.lyf.oauthserver.entity.UserDO
     * @version: V1.0
     */
    @Override
    public UserDO login(UserDO userDO) {
        return userDao.login(userDO.getUserName());
    }

    /**
     * @method  register
     * @Param:  * @param userDO
     * @Description: (用一句话描述该文件做什么)
     * @author DIC.sweetlfy
     * @date 2018/11/15 17:08
     * @Return int
     * @version V1.0
     */
    @Override
    public int register(UserDO userDO) {
        return userDao.register(userDO.getUserName(),userDO.getEmail(), userDO.getPassword(),userDO.getRole());
    }

    /**
     * @method: getAuthorities
     * @Param:  * @param userName
     * @Description: (用一句话描述该文件做什么)
     * @author: DIC.sweetlfy
     * @date: 2018/11/15 17:20
     * @Return: java.util.List
     * @version: V1.0
     */
    @Override
    public List<String> getAuthorities(String userName) {
        List<String> list =  userDao.getAuthorities(userName);
        return list;
    }
}
