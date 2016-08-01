package com.cooksys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.entity.Users;
import com.cooksys.pojo.UserReq;
import com.cooksys.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
@Autowired
UserService userService;
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public Users createUser(@RequestBody UserReq requestUser) {
		return userService.createUser(requestUser);
	}
	@RequestMapping(value="name/{name}")
	public Users getUserByName(@PathVariable String name) {
		return userService.getUserByUsername(name);
	}
	@RequestMapping(value="login",method=RequestMethod.POST)
	public Users loginUser(@RequestBody UserReq requestUser) {
		return userService.login(requestUser);
	}
}
