
package cn.lyf.staticresourceserver.config;

import cn.lyf.staticresourceserver.entity.UserDO;
import cn.lyf.staticresourceserver.service.Impl.UserServiceImpl;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**  问题
 * @author DIC.lyf
 * @version V1.0
 * @Title: UserServiceFallbackFactory
 * @Package cn.lyf.staticresourceserver.config
 * @Description: (用一句话描述该文件做什么)
 * @date 2018/12/7 14:11
 */
//@Component
@Slf4j
public class UserServiceFallbackFactory implements FallbackFactory<UserServiceImpl> {

    @Override
    public UserServiceImpl create(Throwable throwable) {
        return new UserServiceImpl() {
            @Override
            public int register(UserDO userDO) {
                return 0;
            }

            @Override
            public UserDO login(String userName) {
                log.error("**********************************");
                return null;
            }
        };
    }
}

