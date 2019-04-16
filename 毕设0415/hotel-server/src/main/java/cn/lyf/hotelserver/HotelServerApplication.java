package cn.lyf.hotelserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableDiscoveryClient
@EnableGlobalMethodSecurity(prePostEnabled=true)
@MapperScan("cn.lyf.hotelserver.dao")
public class HotelServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelServerApplication.class, args);
	}
}
