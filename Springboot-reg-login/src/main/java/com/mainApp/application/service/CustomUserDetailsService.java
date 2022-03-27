package com.mainApp.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mainApp.application.entity.CustomUserDetails;
import com.mainApp.application.entity.User;
import com.mainApp.application.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(email);
		if(user==null) {
			throw new UsernameNotFoundException("User does not exist.");
		}
		return new CustomUserDetails(user);
	}

}
