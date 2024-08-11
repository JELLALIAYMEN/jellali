package com.example.eurekaserveraa;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaserveraaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaserveraaApplication.class, args);
	}

}
