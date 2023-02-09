package com.cg.dryclean.rest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.dryclean.entity.Usernames;
import com.cg.dryclean.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/getAllUsers")
	public List<Usernames> getAllUsers() 
	{
	    return userService.getAllUsers();
	}
	@GetMapping("/user/{id}")
	public Usernames getUser(@PathVariable int id)
	{
		return userService.getUser(id);
	}
	@PostMapping(value="/addUser", consumes={"application/json"})
  	public Usernames addUser(@RequestBody Usernames user)
  	{
  		return userService.addUser(user);
  	}
	
	@PutMapping("/user/{id}")
	 public Usernames updateUser(@PathVariable int id, @RequestBody Usernames user) 
	{
	    return userService.updateUser(id, user);
	}
	
	
}