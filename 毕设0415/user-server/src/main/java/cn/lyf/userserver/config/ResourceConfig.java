package cn.lyf.userserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import javax.servlet.http.HttpServletResponse;

/**
 * @Title: ResourceConfig
 * @Package cn.lyf.userserver.config
 * @Description: (用一句话描述该文件做什么)
 * @author DIC.sweetlfy
 * @date 2018/11/14 14:30
 * @version V1.0
 */

@Configuration
@EnableResourceServer
public class ResourceConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().exceptionHandling()

                .authenticationEntryPoint(
                        (request,response,authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED)
                )
                .and().authorizeRequests().antMatchers("/users/register").permitAll()
                .and().authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }
}
