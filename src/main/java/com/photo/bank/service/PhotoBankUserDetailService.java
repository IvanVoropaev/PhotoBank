package com.photo.bank.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.photo.bank.dao.PhotoBankDAO;
import com.photo.bank.entity.Roles;
import com.photo.bank.entity.Users;

public class PhotoBankUserDetailService implements UserDetailsService {
	
	@Autowired
	private PhotoBankDAO photoBankDAO;
	
	@Transactional
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		
		System.out.println(photoBankDAO);
		
		Users userEntity = photoBankDAO.getUser(username);
		if (userEntity == null) {
			System.out.println("Error");
			throw new UsernameNotFoundException("user not found");
		}
		
		List<Roles> rolesList = photoBankDAO.getRoles(userEntity);
		
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		for (Roles r : rolesList) {
			roles.add(new GrantedAuthorityImpl(r.getRole().toString()));
		}
		
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
	
	public void authenticateUser(User user) {
        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword(),
                        user.getAuthorities()));
    }
}
