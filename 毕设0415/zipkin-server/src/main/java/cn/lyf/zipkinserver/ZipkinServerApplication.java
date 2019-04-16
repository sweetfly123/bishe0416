package cn.lyf.zipkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * @Title: 	ZipkinServerApplication
 * @Description: zipkin启动类
 * @author: DIC.sweetlfy
 * @date: 2018/11/20 9:36
 * @Return:
 * @version: V1.0
 */
@SpringBootApplication
@EnableZipkinServer
public class ZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinServerApplication.class, args);
	}
}
