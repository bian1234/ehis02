package com.sicmed.ehis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.sicmed.ehis.mapper.master","com.sicmed.ehis.mapper.slaver"})
public class EhisApplication {

	public static void main(String[] args) {
		SpringApplication.run(EhisApplication.class, args);
	}
}
