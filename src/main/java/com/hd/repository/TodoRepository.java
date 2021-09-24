package com.hd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hd.model.Todo;


public interface TodoRepository extends JpaRepository<Todo, Long>{
	
	public List<Todo> findAll();
}
