package com.photo.bank.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.photo.bank.dao.PhotoBankDAO;
import com.photo.bank.entity.Users;

public class PhotoBankUserDetailService implements UserDetailsService {
	
	@Autowired
	private PhotoBankDAO photoBankDAO;
	
	@Transactional
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		
		Users userEntity = photoBankDAO.getUser(username);
		if (userEntity == null) {
			System.out.println("Error");
			throw new UsernameNotFoundException("user not found");
		}
		
		System.out.println(userEntity.getUserName().trim() + " " + userEntity.getPassword().trim() + " " + userEntity.getUserEmail().trim() + " " + userEntity.getUserRole().trim());
		
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		roles.add(new GrantedAuthorityImpl(userEntity.getUserRole().trim()));
		
		String name = userEntity.getUserName().trim();
	    String password = userEntity.getPassword().trim();
	    boolean enabled = true;
	    boolean accountNonExpired = true;
	    boolean credentialsNonExpired = true;
	    boolean accountNonLocked = true;
		
		UserDetails userDetails = new User(name, 
				                           password,
				                           enabled,
				                           accountNonExpired,
				                           credentialsNonExpired,
				                           accountNonLocked,
				                           roles);
		
		System.out.println(userDetails);
		return userDetails;
	}

}
