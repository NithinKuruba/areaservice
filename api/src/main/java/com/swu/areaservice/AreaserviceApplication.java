package com.swu.areaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AreaserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AreaserviceApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
			   registry.addMapping("/**").allowedOrigins("http://localhost:3000");
			}
		 };
	}
}
