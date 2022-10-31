package com.cmpe202.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cmpe202.payload.request.SignupRequest;
import com.cmpe202.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/")
	@ResponseBody
	public ResponseEntity getAllUsers() {
		return new ResponseEntity<>(userService.getAllUserDTO(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity getUserById(@PathVariable long id) {
		return new ResponseEntity(userService.getUserDTOById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity updateUserById(@PathVariable Long id, @Valid @RequestBody SignupRequest signupRequest) {

		userService.updateUser(id, signupRequest);
		return new ResponseEntity(HttpStatus.OK);
	}

}
