package com.devsuperior.configserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class HrConfigServerApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(HrConfigServerApplication.class, args);
	}
	
	//Testa Variavel de ambiente
	@Value("${spring.cloud.config.server.git.username}")
	private String username;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("USERNAME = " + username);
	}

}
