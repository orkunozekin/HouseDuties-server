package com.hd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hd.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
	
	public List<User> findAll();
	public User findByEmail(String email);
	public User findById(long id);
	public List<User> findByPassword(String password);
}
