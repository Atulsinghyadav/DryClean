package com.cg.dryclean.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.dryclean.entity.Usernames;
import com.cg.dryclean.exception.AuthenticationFailureException;
import com.cg.dryclean.exception.UserNotFoundException;
import com.cg.dryclean.repository.UsersRepo;

@Service
public class AuthServiceInterfaceImpl  implements AuthServiceInterface{
	@Autowired
	private UsersRepo usersRepo;
	
	@Override
	public Usernames login(String email, String password) {
		Optional<Usernames> optionalUsernames = usersRepo.findUserByEmail(email);
		if(optionalUsernames.isEmpty()) {
			throw new  UserNotFoundException();
		}
		Usernames usernames = optionalUsernames.get();
		if(!password.equals(usernames.getPassword())) {
			throw new AuthenticationFailureException();
		}
		return usernames;
	}
		
	
}
