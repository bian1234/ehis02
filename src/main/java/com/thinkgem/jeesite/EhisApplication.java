package com.thinkgem.jeesite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration(exclude={WebMvcAutoConfiguration.class})
//@EnableAutoConfiguration  //增加exclude 信息，否则不能启动
@ComponentScan(basePackages = "com.thinkgem.jeesite.cfq.mobile.rest.dao")
public class EhisApplication {

	public static void main(String[] args) {
		SpringApplication.run(EhisApplication.class, args);
	}
}
