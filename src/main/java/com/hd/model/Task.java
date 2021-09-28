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
@Table(name="task")
public class Task {
	
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
	private Household household;
	
	
	
	public Task() {
		// TODO Auto-generated constructor stub
	}



	public Task(long id, String name, String type, boolean completed, User userAssigned, String completionDate,
			Household household) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.completed = completed;
		this.userAssigned = userAssigned;
		this.completionDate = completionDate;
		this.household = household;
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



	public Household getHousehold() {
		return household;
	}



	public void setHousehold(Household household) {
		this.household = household;
	}



	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", type=" + type + ", completed=" + completed + ", userAssigned="
				+ userAssigned + ", completionDate=" + completionDate + ", household=" + household + "]";
	}


	
	
}
