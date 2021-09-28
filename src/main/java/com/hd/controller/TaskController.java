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
import com.hd.model.Task;
import com.hd.repository.HouseholdRepository;
import com.hd.repository.TaskRepository;

@RestController
@RequestMapping("/task")
@CrossOrigin(origins = "*")
public class TaskController {
	
	private TaskRepository tr;
	private HouseholdRepository hr; 
	
	@GetMapping("/getAllTasks")
	public List<Task> getAllTasks() {
		return tr.findAll();
	}
	
	@PostMapping("/createNewTask")
	public String createNewTask(@RequestBody Task task) {
		System.out.println("task:" + task);
		if(task.getType() != null) {
			Household household = task.getHousehold();
			tr.save(task);
			hr.save(household);
			return "task has been added!";
		} else {
			return "task creation has failed.";
		}
	
	}
	
	@Autowired
	public TaskController(TaskRepository tr, HouseholdRepository hr) {
		super();
		this.tr = tr;
		this.hr = hr;
	}

	public TaskRepository getTr() {
		return tr;
	}

	public void setTr(TaskRepository tr) {
		this.tr = tr;
	}

	public HouseholdRepository getHr() {
		return hr;
	}

	public void setHr(HouseholdRepository hr) {
		this.hr = hr;
	}

	
}
