package com.hd.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "fullname", nullable = false)
	private String fullName;

	@Column(name = "password", nullable = false)
	private String password;

	@OneToMany(mappedBy = "userAssigned", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private Set<Todo> todos;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "household_id")
	@JsonIgnore
	private Household household;


	public User() {
		// TODO Auto-generated constructor stub
	}


	public User(long id, String email, String fullName, String password, Set<Todo> todos, Household household) {
		super();
		this.id = id;
		this.email = email;
		this.fullName = fullName;
		this.password = password;
		this.todos = todos;
		this.household = household;
	}


	public User(String email, String fullName, String password, Set<Todo> todos, Household household) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.password = password;
		this.todos = todos;
		this.household = household;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Set<Todo> getTodos() {
		return todos;
	}


	public void setTodos(Set<Todo> todos) {
		this.todos = todos;
	}


	public Household getHousehold() {
		return household;
	}


	public void setHousehold(Household household) {
		this.household = household;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", fullName=" + fullName + ", password=" + password + ", todos="
				+ todos + ", household=" + household + "]";
	}

	

}
