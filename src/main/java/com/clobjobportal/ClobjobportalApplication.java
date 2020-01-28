package com.clobjobportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.clobjobportal")

public class ClobjobportalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClobjobportalApplication.class, args);
	}

}
