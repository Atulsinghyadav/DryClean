package com.cg.dryclean.rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.dryclean.entity.Usernames;
import com.cg.dryclean.service.UserService;

@CrossOrigin(origins= "http://localhost:3000")
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	//To RETRIEVE details of all users present in database
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<Usernames>> getAllUsers() 
	{
		List<Usernames> allUsers = userService.getAllUsers();
		return ResponseEntity.ok(allUsers);
	}
	
	//To RETRIEVE details of User with a specific ID
	@GetMapping("/user/{id}")
	public ResponseEntity<Usernames> getUser(@PathVariable int id)
	{
		return ResponseEntity.ok(userService.getUser(id));
	}
	
	//To ADD a new user into the database
	@PostMapping(value="/addUser", consumes={"application/json"})
  	public ResponseEntity<Usernames> addUser(@RequestBody Usernames user)
  	{
  		return ResponseEntity.ok(userService.addUser(user));
  	}
	
	//To UPDATE details of an existing User
	@PutMapping("/user/{id}")
	 public ResponseEntity<Usernames> updateUser(@PathVariable int id, @RequestBody Usernames user) 
	{
	    return  ResponseEntity.ok(userService.updateUser(id, user));
	}
	
}