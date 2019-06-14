package com.icard.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.icard.web"})

public class IcardApplication {

	public static void main(String[] args) {
		SpringApplication.run(IcardApplication.class, args);
	}

}
