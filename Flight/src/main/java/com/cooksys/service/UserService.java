package com.cooksys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.Users;
import com.cooksys.pojo.UserReq;
import com.cooksys.repository.UserRepository;

@Service
public class UserService {
@Autowired
UserRepository userRepo;

	public Users createUser(UserReq requestUser) {
		Users user = checkExisting(requestUser);
		if (user != null) {
			userRepo.save(user);
		}
		return user;
	}
	
	private Users checkExisting(UserReq requestUser) {
		Users existing = getUserByUsername(requestUser.getUsername());
		
		if (existing == null) {
			Users user = new Users();
			user.setUsername(requestUser.getUsername());
			user.setPassword(requestUser.getPassword());
			return user;
		}
		{
			 throw new IllegalArgumentException("The 'name' already exists");
		}
	}

	public Users getUserByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	public Users login(UserReq requestUser) {
		Users onFile = getUserByUsername(requestUser.getUsername());
		Users toLogin = new Users();
		toLogin.setUsername(requestUser.getUsername());
		toLogin.setPassword(requestUser.getPassword());
		
		if (verifyUser(toLogin, onFile)) {
			return onFile;
		}
		
		{
			 throw new IllegalArgumentException("The name or the password is wrong.Try logging in again");
		}
	}
	private boolean verifyUser(Users toLogin, Users onFile) {
		if (toLogin == null || onFile == null)
			return false;
		return (toLogin.getUsername().equals(onFile.getUsername()) && toLogin.getPassword().equals(onFile.getPassword()));
	}
}

