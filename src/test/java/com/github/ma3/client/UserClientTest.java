package com.github.ma3.client;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.ma3.controller.UserClient;

@SpringBootTest
class UserClientTest {

	@Autowired
	UserClient client;
	
	@Test
	void givenFeignClient_whenFindById_thenOk() {
		User user = client.findById(1);
		
		assertThat(user).isNotNull();
		assertThat(user.getId()).isEqualTo(1);
		assertThat(user.getName()).isEqualTo("Leanne Graham");
	}

}
