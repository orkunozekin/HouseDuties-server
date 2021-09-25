package com.hd.controller;

import java.util.ArrayList;
import java.util.List;

import com.hd.service.HouseHoldService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hd.model.Household;

@RestController
@RequestMapping("/household")
@CrossOrigin(origins="*")
@RequiredArgsConstructor
public class HouseholdController {

	private final HouseHoldService houseHoldService;
	@GetMapping("/getAllHouseholds")
	public ResponseEntity<List<Household>> getAllHouseholds() {
		List<Household> households = houseHoldService.get();
		if(null == households || households.isEmpty()) {
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(households, HttpStatus.OK);
	}

	@PostMapping("/newHousehold")
	public ResponseEntity<Household> createNewHousehold(@RequestBody Household household) {
		return new ResponseEntity<Household>(houseHoldService.save(household), HttpStatus.OK);
	}

	
}
