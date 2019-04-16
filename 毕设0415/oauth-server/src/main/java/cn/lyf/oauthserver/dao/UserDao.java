package cn.lyf.oauthserver.dao;

import cn.lyf.oauthserver.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 使用Repository而不用service
 * 这是从Spring 2.0开始新增的注解，用于简化 Spring 的开发，其将数据访问层的类标识为Spring Bean。
 * 同时它还能将所标注的类中抛出的数据访问异常封装为 Spring 的数据访问异常类型。
 */
@Repository
public interface UserDao {
    /**
     * @method: login
     * @Param:  * @param userName
     * @Description: 登录，从数据中获取用户信息
     * @author: DIC.sweetlfy
     * @date: 2018/11/15 17:15
     * @Return: cn.lyf.oauthserver.entity.UserEntity
     * @version: V1.0
     */
    UserEntity login(String userName);
    /**
     * @method:
     * @Param:  * @param null
     * @Description: 注册
     * @author: DIC.sweetlfy
     * @date: 2018/11/15 17:16
     * @Return:
     * @version: V1.0
     */
    int register(@Param("userName") String userName, @Param("password") String password);

    /**
     * @method: getAuthorities
     * @Param:  * @param username
     * @Description: 获取用户权限集合
     * @author: DIC.sweetlfy
     * @date: 2018/11/15 17:17
     * @Return: java.util.List
     * @version: V1.0
     */
    List<String> getAuthorities(String userName);
}
