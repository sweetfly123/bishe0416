package cn.lyf.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Title: EurekaServerApplication
 * @Package cn.lyf.eurekaserver
 * @Description: 注册中心启动类
 * @author DIC.sweetlfy
 * @date 2018/11/14 14:30
 * @version V1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}
