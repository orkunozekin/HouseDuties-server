package com.hd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hd.model.Household;

public interface HouseholdRepository extends JpaRepository<Household, Long>{
	
	public List<Household> findAll();
}
