package com.hd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hd.model.Task;


public interface TaskRepository extends JpaRepository<Task, Long>{
	
	public List<Task> findAll();
}
