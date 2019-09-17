package com.example.demo.controller;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.GreetingEntity;
import com.example.demo.entity.MobileUsageEntity;

public interface MobileUsageRepository extends  CrudRepository<MobileUsageEntity, String>{

}
