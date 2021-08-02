package com.github.ma3.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.get;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@SpringBootTest
class HelloControllerTest {

	@Autowired
	private WebApplicationContext ctx;
	
	@BeforeEach
	public void setUp() {
		RestAssuredMockMvc.webAppContextSetup(ctx);
	}

	@Test
	void whenGetHello_thenOk() {
		// @formatter:off
		get("/api/hello")
		.then()
			.statusCode(200)
			.assertThat().body("id", equalTo(1))
			.assertThat().body("name", equalTo("Leanne Graham"));
		// @formatter:on

	}

	@Test
	void givenFeignClient_whenGetAppApiDoc_thenFeignClientShouldNotAppear() {
		// @formatter:off
		given()
		.when()
			.get("/v3/api-docs")
		.then()
			.statusCode(200)
			.body("paths['/users/{id}'].get", nullValue());
		// @formatter:on
	}
}
