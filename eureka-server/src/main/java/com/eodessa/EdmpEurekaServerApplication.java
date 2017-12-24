package com.eodessa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EdmpEurekaServerApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(EdmpEurekaServerApplication.class);

	public static void main(String[] args) {
		LOGGER.debug("The Eureka Server is running ............");
		SpringApplication.run(EdmpEurekaServerApplication.class, args);
	}
}
