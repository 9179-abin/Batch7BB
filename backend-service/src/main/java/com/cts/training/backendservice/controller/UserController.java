package com.cts.training.backendservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.backendservice.models.Users;
import com.cts.training.backendservice.repo.UserRepo;

@RestController
public class UserController {
	
	@Autowired
	UserRepo userrepo;
	
	@GetMapping("/")
	public String start() {
		return "Hello";
	}
	
	@GetMapping("/users")
	public List<Users> findAll() {
		return userrepo.findAll();
	}
	
	@GetMapping("/users/{id}")
	public Users findOne(@PathVariable int id) {
		Optional<Users> usr = userrepo.findById(id);
		Users us = usr.get();
		return us;
	}
	
	@PostMapping("/users")
	public Users save(@RequestBody Users usr) {
		Users us = userrepo.save(usr);
		return us;
	}
	
	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable int id) {
		userrepo.deleteById(id);
	}
	
	@PutMapping("/users")
	public Users update(@RequestBody Users usr) {
		Users us = userrepo.save(usr);
		return us;
	}

}
