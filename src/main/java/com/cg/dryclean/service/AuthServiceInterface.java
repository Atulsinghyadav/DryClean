package com.cg.dryclean.service;
import com.cg.dryclean.entity.Usernames;

public interface AuthServiceInterface {
	public Usernames login(String email, String password);
}
