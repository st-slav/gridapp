package ru.mamsta.gridapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
@ComponentScan
public class AppConf {

	public static void main(String[] args) {
		System.out.println("User out: application config start;");
		SpringApplication.run(AppConf.class, args);
	}
}
