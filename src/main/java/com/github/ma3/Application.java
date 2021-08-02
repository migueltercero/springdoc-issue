package com.github.ma3;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public GroupedOpenApi storeOpenApi() {
		// @formatter:off
		return GroupedOpenApi.builder()
								.group("hello")
								.pathsToMatch("/**")
							.build();
		// @formatter:on		
	}
}
