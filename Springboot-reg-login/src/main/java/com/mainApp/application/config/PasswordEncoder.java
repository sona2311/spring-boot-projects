package com.mainApp.application.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
	
	public static void main(String args[]) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String rawPassword = "qsasas";
		String newPass = passwordEncoder.encode(rawPassword);
		System.out.println("Encoded password : " + newPass);
	}

}
