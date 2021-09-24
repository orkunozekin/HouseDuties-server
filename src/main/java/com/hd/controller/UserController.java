package com.hd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hd.model.User;
import com.hd.repository.UserRepository;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
	
	private UserRepository uRepo;
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return uRepo.findAll();
	}
	
	//checks to see if this email already exists, if it doesn't, returns true.
	@PostMapping("/checkEmail")
	public boolean checkEmail(@RequestParam String email) {
		User user = uRepo.findByEmail(email);
		return user != null;
	}
	
	@PostMapping("/createNewUser")
	public ResponseEntity<User> createNewUser(@RequestBody User newUser) {
		System.out.println(newUser);
		if(newUser.getEmail().length() > 0) {
			uRepo.save(newUser);
			System.out.println("Successfully created");
			return ResponseEntity.accepted().body(newUser);
		}
		return (ResponseEntity<User>) ResponseEntity.badRequest();
	}
	
	@PostMapping("/login")
	public User loginUser(@RequestParam String email) {
		System.out.println(email);
		User loggedInUser = uRepo.findByEmail(email);
		System.out.println(loggedInUser);
		if(loggedInUser != null) {
			return loggedInUser;
		}
		return null;
	}
	
	
	
	//constructor
	
	@Autowired
	public UserController(UserRepository uRepo) {
		this.uRepo = uRepo;
	}
	
	//getters&setters
	public UserRepository getuRepo() {
		return uRepo;
	}

	public void setuRepo(UserRepository uRepo) {
		this.uRepo = uRepo;
	}
	
	
	
	
}
