package com.example.demo.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.GreetingEntity;
import com.example.demo.entity.MobileUsageEntity;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	private GreetingRepository repository;
	private MobileUsageRepository mobileUsageRepository;

	public RestController(GreetingRepository repository,MobileUsageRepository mobileUsageRepository) {
		this.repository = repository;
		this.mobileUsageRepository = mobileUsageRepository;
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
	
	@GetMapping(value = "/api/mobileusage", produces = "application/json")
	public List<MobileUsage> getUsages() throws SQLException {

		Iterable<MobileUsageEntity> list = mobileUsageRepository.findAll();
		List<MobileUsage> mobileUsageList = new ArrayList<>();
		
		for(MobileUsageEntity entity : list) {
			MobileUsage mobileUsage = new MobileUsage();
			mobileUsage.setBillingMonth(entity.getBillingMonth());
			mobileUsage.setCustName(entity.getCustName());
			mobileUsage.setDataUsage(entity.getDataUsage());
			mobileUsageList.add(mobileUsage);
		}

		return mobileUsageList;

	}
	
	
	@PostMapping(value = "/", consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseEntity<MobileUsage> createNew(
			@RequestBody MobileUsage mobileUsage) {
		MobileUsageEntity mobileUsageEntity = new MobileUsageEntity();
		mobileUsageEntity.setBillingMonth(mobileUsage.getBillingMonth());
		mobileUsageEntity.setCustName(mobileUsage.getCustName());
		mobileUsageEntity.setDataUsage(mobileUsage.getDataUsage());;
		mobileUsageRepository.save(mobileUsageEntity);
		return new ResponseEntity<>(mobileUsage, HttpStatus.CREATED);
	}
	

}
