package com.otto.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.otto.controller.RegionsController;
import com.otto.service.RegionsServiceImpl;

@SpringBootApplication
@ComponentScan(basePackageClasses = RegionsController.class)
public class RegionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegionsApplication.class, args);
	}
	
	@Bean
	public RegionsServiceImpl getRegionService() {
		return new RegionsServiceImpl();
	}
	
}
