package com.hd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hd.model.Household;
import com.hd.repository.HouseholdRepository;

@RestController
@RequestMapping("/household")
@CrossOrigin(origins="*")
public class HouseholdController {
	
	private HouseholdRepository hr;
	
	@GetMapping("/getAllHouseholds")
	public List<Household> getAllHouseholds() {
		return hr.findAll();
	}
	
	@PostMapping("/newHousehold")
	public String createNewHousehold(@RequestBody Household household) {
		System.out.println("household name: " + household.getName());
		if(household.getName() != null) {
			hr.save(household);
			return "Household has been created!";
		} else {
			return "Failed to create household!";
		}
	}
	
	
	
	@Autowired
	public HouseholdController(HouseholdRepository hr) {
		this.hr = hr;
	}



	public HouseholdRepository getHr() {
		return hr;
	}



	public void setHr(HouseholdRepository hr) {
		this.hr = hr;
	}
	
	
	
}
