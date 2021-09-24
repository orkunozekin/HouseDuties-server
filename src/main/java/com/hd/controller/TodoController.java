package com.hd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hd.model.Todo;
import com.hd.repository.TodoRepository;

@RestController
@RequestMapping("/todo")
@CrossOrigin(origins = "*")
public class TodoController {
	
	private TodoRepository tr;
	
	@GetMapping("/getAllTodos")
	public List<Todo> getAllTodos() {
		return tr.findAll();
	}
	
	@PostMapping("/createNewTodo")
	public String createNewTodo(@RequestBody Todo todo) {
		System.out.println("todo:" + todo);
		if(todo.getType() != null) {
			tr.save(todo);
			return "Todo has been added!";
		} else {
			return "Todo creation has failed.";
		}
	
	}
	
	@Autowired
	public TodoController(TodoRepository tr) {
		super();
		this.tr = tr;
	}

	public TodoRepository getTr() {
		return tr;
	}

	public void setTr(TodoRepository tr) {
		this.tr = tr;
	}
}
