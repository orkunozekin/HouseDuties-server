package com.hd.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "household")
public class Household {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name", nullable = false)
	private String name;

	@OneToMany(mappedBy = "household", fetch = FetchType.EAGER)
	private Set<User> users;

	@OneToMany(mappedBy = "household", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Task> tasks;

	public Household() {
	}

	public Household(long id, String name, Set<User> users, Set<Task> tasks) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
		this.tasks = tasks;
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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "Household [id=" + id + ", name=" + name + ", users=" + users + ", tasks=" + tasks + "]";
	}

	
	
	
}
