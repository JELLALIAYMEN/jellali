package com.example.pfegestiondocument;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PfEgestionDocumentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PfEgestionDocumentApplication.class, args);
	}

}
