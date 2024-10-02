package com.example.gatewayaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GatewayaaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayaaApplication.class, args);

	}

}
