package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class BootMsProj17MiniProjectAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj17MiniProjectAdminServerApplication.class, args);
	}

}
