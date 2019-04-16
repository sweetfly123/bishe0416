package cn.lyf.staticresourceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @Title: StaticResourceServerApplication
 * @Package cn.lyf.staticresourceserver
 * @Description: 静态资源启动类
 * @author DIC.sweetlfy
 * @date 2018/11/14 14:30
 * @version V1.0
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"cn.lyf.staticresourceserver.service"})
public class StaticResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaticResourceServerApplication.class, args);
	}
}
