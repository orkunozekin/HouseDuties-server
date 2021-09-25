package com.hd.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hd.model.Household;
import com.hd.model.User;
import com.hd.repository.HouseholdRepository;
import com.hd.repository.UserRepository;

@RestController
@RequestMapping("/household")
@CrossOrigin(origins="*")
public class HouseholdController {
	
	private HouseholdRepository hr;
	private UserRepository uRepo;
	
	@GetMapping("/getAllHouseholds")
	public List<Household> getAllHouseholds() {
		return hr.findAll();
	}
	
	@PostMapping("/newHousehold")
	public String createNewHousehold(@RequestBody Household household) {
		System.out.println("household name: " + household.getName());
		System.out.println("household users: " + household.getUsers());
		if(household.getName() != null) {
//			Set<User> usersSet = household.getUsers();
//			User[] users = usersSet.toArray(new User[usersSet.size()]);
//			System.out.println("first user: " + users[0]);
//			uRepo.save(users[0]);
			hr.save(household);
			return "Household has been created!";
		} else {
			return "Failed to create household!";
		}
	}
	
	
	
	@Autowired
	public HouseholdController(HouseholdRepository hr, UserRepository uRepo) {
		this.uRepo = uRepo;
		this.hr = hr;
	}

	public HouseholdRepository getHr() {
		return hr;
	}

	public void setHr(HouseholdRepository hr) {
		this.hr = hr;
	}

	public UserRepository getuRepo() {
		return uRepo;
	}

	public void setuRepo(UserRepository uRepo) {
		this.uRepo = uRepo;
	}



	
	
	
	
}
