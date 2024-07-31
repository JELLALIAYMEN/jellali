package com.example.gestioncantine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class GestionCantineApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionCantineApplication.class, args);
	}

}
