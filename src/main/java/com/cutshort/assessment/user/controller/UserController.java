package com.cutshort.assessment.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cutshort.assessment.user.entity.User;
import com.cutshort.assessment.user.model.LoginCredentials;
import com.cutshort.assessment.user.model.UserDTO;
import com.cutshort.assessment.user.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/authenticate")
	public ResponseEntity<Boolean> authenticate(@RequestBody LoginCredentials loginCredentials) {
		return new ResponseEntity<>(userService.authenticate(loginCredentials), HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<User> findById(@RequestParam("id") Integer id) {
		return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<User>> findById(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
		return new ResponseEntity<>(userService.findAll(PageRequest.of(page, size)), HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<User> save(@RequestBody UserDTO userDTO) {
		return new ResponseEntity<>(userService.save(userDTO.toEntity()), HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Void> delete(@RequestParam("id") Integer id) {
		userService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
