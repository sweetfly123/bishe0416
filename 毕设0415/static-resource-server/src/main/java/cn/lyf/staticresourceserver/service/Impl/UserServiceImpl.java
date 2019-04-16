package cn.lyf.staticresourceserver.service.Impl;


import cn.lyf.staticresourceserver.entity.UserDO;
import cn.lyf.staticresourceserver.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author DIC.lyf
 * @version V1.0
 * @Title: UserServiceImpl
 * @Package cn.lyf.staticresourceserver.service.Impl
 * @Description: (用一句话描述该文件做什么)
 * @date 2018/12/10 11:27
 */
@Component
@Slf4j
public class UserServiceImpl implements UserService {
    @Override
    public int register(UserDO userDO) {
        return 0;
    }

    @Override
    public UserDO login(String userName) {
        log.error("服务异常");
        return null;
    }
}
