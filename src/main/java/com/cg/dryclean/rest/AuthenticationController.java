package com.cg.dryclean.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.dryclean.entity.Usernames;
import com.cg.dryclean.dto.LoginRequest;
import com.cg.dryclean.service.AuthServiceInterface;

@CrossOrigin(origins= "http://localhost:3000")
@RestController
public class AuthenticationController {
	@Autowired
	private AuthServiceInterface authServiceInterface;
	
	@PostMapping("/login")
	public ResponseEntity<Usernames> doLogin(@RequestBody LoginRequest loginRequest){
		Usernames usernames = authServiceInterface.login(loginRequest.getEmail(),  loginRequest.getPassword());
		ResponseEntity<Usernames> responseEntity = new ResponseEntity<>(usernames,HttpStatus.OK);
		return responseEntity;
	}
}
