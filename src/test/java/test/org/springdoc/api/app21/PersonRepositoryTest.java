package test.org.springdoc.api.app21;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.WebApplicationContext;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@SpringBootTest
class PersonRepositoryTest {
	
	@Autowired
	private WebApplicationContext ctx;
	
	@BeforeEach
	public void setUp() {
		RestAssuredMockMvc.webAppContextSetup(ctx);
	}

	@Test
	void given_repositoryRestResource_when_getApiDocs_then_findByLastNameDocumentationOk() {
		// @formatter:off
		given()
		.when()
			.get("/v3/api-docs")
		.then()
			.status(HttpStatus.OK)
			.rootPath("paths['/peopleme/search/findByLastName']")
				.body("get.description", equalTo("this is my test"));
		// @formatter:on
	}
	
	@Test
	void given_repositoryRestResource_when_getApiDocs_then_findByIdDocumentationOk() {
		// @formatter:off
		given()
		.when()
			.get("/v3/api-docs")
		.then()
			.status(HttpStatus.OK)
			.rootPath("paths['/peopleme/{id}']")
				.body("get.description", equalTo("find by id"));
		// @formatter:on
	}

}
