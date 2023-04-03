package com.weather.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.weather.entity.DiceUser;
import com.weather.repository.UserRepository;

@Service
public class CustomUserDetails implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DiceUser user = repository.findByUserName(username);
		return new User(user.getUserName(), user.getPassword(), new ArrayList<>());
	}
}
