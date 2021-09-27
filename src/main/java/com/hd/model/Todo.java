package com.hd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="todo")
public class Todo {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="type")
	private String type;
	
	@Column(name="completed")
	private boolean completed;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_assigned")
	private User userAssigned;
	
	@Column(name="completion_date")
	private String completionDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "household_id")
//	@JsonIgnore
	private Household householdOfTodo;
	
	
	
	public Todo() {
		// TODO Auto-generated constructor stub
	}



	public Todo(long id, String name, String type, boolean completed, User userAssigned, String completionDate,
			Household householdOfTodo) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.completed = completed;
		this.userAssigned = userAssigned;
		this.completionDate = completionDate;
		this.householdOfTodo = householdOfTodo;
	}



	public Todo(String name, String type, boolean completed, User userAssigned, String completionDate,
			Household householdOfTodo) {
		super();
		this.name = name;
		this.type = type;
		this.completed = completed;
		this.userAssigned = userAssigned;
		this.completionDate = completionDate;
		this.householdOfTodo = householdOfTodo;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public boolean isCompleted() {
		return completed;
	}



	public void setCompleted(boolean completed) {
		this.completed = completed;
	}



	public User getUserAssigned() {
		return userAssigned;
	}



	public void setUserAssigned(User userAssigned) {
		this.userAssigned = userAssigned;
	}



	public String getCompletionDate() {
		return completionDate;
	}



	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}



	public Household getHouseholdOfTodo() {
		return householdOfTodo;
	}



	public void setHouseholdOfTodo(Household householdOfTodo) {
		this.householdOfTodo = householdOfTodo;
	}



	@Override
	public String toString() {
		return "Todo [id=" + id + ", name=" + name + ", type=" + type + ", completed=" + completed + ", userAssigned="
				+ userAssigned + ", completionDate=" + completionDate + ", householdOfTodo=" + householdOfTodo + "]";
	}



	
	
	
}
