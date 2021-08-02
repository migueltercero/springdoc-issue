package com.github.ma3.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.ma3.client.User;

@FeignClient("dummy")
@RequestMapping(value= "/users", consumes = "application/json")
public interface UserClient {

	@GetMapping("/{id}")
	public User findById(@PathVariable Integer id);
}
