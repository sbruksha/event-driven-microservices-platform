package com.eodessa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableConfigServer
public class EdmpConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdmpConfigServerApplication.class, args);
	}
}
