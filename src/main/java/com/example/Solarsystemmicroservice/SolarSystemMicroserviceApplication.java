package com.example.Solarsystemmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SolarSystemMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolarSystemMicroserviceApplication.class, args);
	}

}
