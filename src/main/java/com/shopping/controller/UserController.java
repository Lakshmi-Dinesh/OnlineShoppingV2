package com.shopping.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.model.User;
import com.shopping.services.UserService;

@RestController
@RequestMapping("userservice")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("get-all")
	public ResponseEntity<ArrayList> getAllUsers(){
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	@GetMapping("by-name")
	public ResponseEntity<ArrayList> findByName(@RequestParam String userName){
		return ResponseEntity.ok(userService.findByName(userName));
	}
	
	@GetMapping("unique-name")
	public ResponseEntity isUserNameUnique(@RequestParam String userName){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.isUserNameUnique(userName));
	}
	
	@PostMapping("user/create")
	public ResponseEntity create(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.createUser(user));
	}
	
	@GetMapping("user/login")
	public ResponseEntity login(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.login(user));
	}

	
}
