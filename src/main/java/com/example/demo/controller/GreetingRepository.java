package com.example.demo.controller;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.GreetingEntity;

public interface GreetingRepository extends  CrudRepository<GreetingEntity, String>{

}
