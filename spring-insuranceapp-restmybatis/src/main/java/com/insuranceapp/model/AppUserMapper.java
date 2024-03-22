package com.insuranceapp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AppUserMapper {
	// convert UserDetails to AppUser
	public AppUser convertToAppUser(UserDetails userDetails) {
		String username = userDetails.getUsername();
		String password = userDetails.getPassword();
		AppUser appUser = new AppUser();
		appUser.setUsername(username);
		appUser.setPassword(password);
		return appUser;
	}
	
	// from db to front-end
	// convert AppUser to UserDetails
		public UserDetails convertToUserDetails(AppUser appUser) {
			String username = appUser.getUsername();
			String password = appUser.getPassword();
			List<GrantedAuthority> authorities = new ArrayList<>();
			
			// create roles for user
			List<String> roles = Arrays.asList("user","admin");
			for(String role : roles) {
				// create a simpleGranted authority
				SimpleGrantedAuthority simplAuthority = new SimpleGrantedAuthority(role);
				// add to List of grantedAuthority
				authorities.add(simplAuthority);
			}
			UserDetails details = new User(username, password, authorities);
			return details;
		}
}
