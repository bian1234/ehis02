package com.thinkgem.jeesite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.thinkgem.jeesite.cfq.mobile.rest.dao")
public class EhisApplication {

	public static void main(String[] args) {
		SpringApplication.run(EhisApplication.class, args);
	}
}
