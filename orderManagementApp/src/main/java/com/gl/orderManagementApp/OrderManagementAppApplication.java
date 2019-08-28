package com.gl.orderManagementApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class OrderManagementAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderManagementAppApplication.class, args);
	}

}
