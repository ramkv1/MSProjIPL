package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BootMsProj17MiniProjectIplTeamServiceProducerMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj17MiniProjectIplTeamServiceProducerMsApplication.class, args);
	}

}
