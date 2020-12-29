package com.mychat.mychat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
//@Configuration 
//@EnableAutoConfiguration
//@ComponentScan({"com.myChat.myChat.business", "com.myChat.myChat.models", "com.myChat.myChat.business.repositories", "com.myChat.myChat.business.resources"})
public class MychatApplication {

	public static void main(String[] args) {
		SpringApplication.run(MychatApplication.class, args);
	}

}
