package com.projectcrist.pokeapi.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projectcrist.pokeapi.app.daos.IUserDao;
import com.projectcrist.pokeapi.app.models.Users;

@Service
public class JpaAuthenticationLogin implements UserDetailsService{

	@Autowired
	private IUserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users user = userDao.findUserByEmail(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("Lo sentimos pero no se encuentra registrado dicho usuario");
		}
		
		List<GrantedAuthority> userAuthorizations = new ArrayList<GrantedAuthority>();
		userAuthorizations.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		return new User(user.getUserEmail(), user.getUserPassword(), true, true, true, true, userAuthorizations);
	}

}
