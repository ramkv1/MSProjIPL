package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BootMsProj17MiniProjectEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj17MiniProjectEurekaServerApplication.class, args);
	}

}
