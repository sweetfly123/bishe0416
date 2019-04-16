package cn.lyf.oauthserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Title: OauthServerApplication
 * @Package cn.lyf.oauthserver
 * @Description: 安全框架启动类
 * @author DIC.sweetlfy
 * @date 2018/11/14 14:30
 * @version V1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("cn.lyf.oauthserver.dao")
public class OauthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthServerApplication.class, args);
	}
}
