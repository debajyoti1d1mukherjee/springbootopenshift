package com.example.demo.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.GreetingEntity;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	private GreetingRepository repository;

	public RestController(GreetingRepository repository) {
		this.repository = repository;

	}

	@GetMapping(value = "/api/greeting", produces = "application/json")
	public List<Greeting> getGreetings() throws SQLException {

		Iterable<GreetingEntity> list = repository.findAll();
		List<Greeting> greetingList = new ArrayList<>();
		
		for(GreetingEntity greetingEntity : list) {
			Greeting greeting = new Greeting(greetingEntity.getGreeting());
			greetingList.add(greeting);
		}

		return greetingList;

	}

}
