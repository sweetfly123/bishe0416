package cn.lyf.hotelserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import javax.servlet.http.HttpServletResponse;

/**
 * @Title: ResourceConfig
 * @Description: 安全验证
 * @author: DIC.lyf
 * @date: 2018/12/7 11:54
 * @Return:
 * @version: V1.0
 */
@Configuration
@EnableResourceServer
public class ResourceConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.exceptionHandling().authenticationEntryPoint(
                (request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED)
        )
                .and().authorizeRequests().antMatchers("/static/**","/resources/**", "/favicon.ico", "/js_pre/*.js_pre", "/*.html", "/css_pre/*.css_pre", "/images_pre/*.*").permitAll()
                .and().authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }
}
