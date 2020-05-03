package com.cts.training.backendservice.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.backendservice.models.Users;
import com.cts.training.backendservice.repo.UserRepo;
import com.cts.training.backendservice.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserRepo userrepo;
	
	@Autowired
	UserService userservice;
	
	
	@GetMapping("/users")
	public List<Users> findAll() {
		return userservice.getAll();
	}
	
	@GetMapping("/users/{id}")
	public Users findOne(@PathVariable int id) {
		Users us = userservice.getOne(id);
		return us;
	}
	
	@PostMapping("/users")
	public Users save(@RequestBody Users usr) {
		Users us = userservice.insert(usr);
		return us;
	}
	
	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable int id) {
		userservice.remove(id);
	}
	
	@PutMapping("/users")
	public Users update(@RequestBody Users usr) {
		Users us = userservice.alter(usr);
		return us;
	}
	@GetMapping("/users/login")
	public ResponseEntity<?> login(HttpServletRequest request){
		String credentials =null;
		String authorization = request.getHeader("Authorization");
		if (authorization != null && authorization.startsWith("Basic")) {
			String base64Credentials = authorization.substring("Basic".length()).trim();
		    byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
		    credentials = new String(credDecoded, StandardCharsets.UTF_8);
		}
		try {
			Users user = userservice.getUserByUsernameAndPassword(credentials.split(":")[0],credentials.split(":")[1]);
			
			return new ResponseEntity<Users>(user,HttpStatus.OK);
		} catch (Exception e ) {
			System.out.println(e.getStackTrace());
			return new ResponseEntity<String>("No user found",HttpStatus.NOT_FOUND);
		}
	}
	

}
