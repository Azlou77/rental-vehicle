package com.example.catalogue.service;

import static org.springframework.security.core.userdetails.User.withUsername;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.catalogue.entity.User;
import com.example.catalogue.repository.UserRepository;
import com.example.catalogue.security.CustomUserDetails;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Email non trouvé : " + email));

		return new CustomUserDetails(user); 
	}
    

  
}