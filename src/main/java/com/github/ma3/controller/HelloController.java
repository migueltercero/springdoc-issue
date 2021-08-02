package com.github.ma3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.ma3.client.User;

@RestController
@RequestMapping(value= "/api", produces = "application/json")
public class HelloController {

	@Autowired
	UserClient client;
	
	@GetMapping("/hello")
	public ResponseEntity<User> hello() {
		User user = client.findById(1);
		return new ResponseEntity<>(user, HttpStatus.OK);

	}
}
