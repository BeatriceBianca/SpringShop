package com.mds.springshop.authentication;

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
import com.mds.springshop.dao.UsersDAO;
import com.mds.springshop.entity.Users;

@Service
public class AuthenticationService implements UserDetailsService {
	@Autowired
	private UsersDAO userDAO;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
	{
		Users user=userDAO.findUserEmail(email);
		System.out.println("User= " + user);
		
		
		if(user==null)
		{
			throw new UsernameNotFoundException("User "+ email + "was not found");
		}
		
		String role=user.getRole();
		List<GrantedAuthority> grantList=new ArrayList<GrantedAuthority>();
		
		GrantedAuthority authority=new SimpleGrantedAuthority("ROLE_" + role);
		
		grantList.add(authority);
		
		boolean enabled=true;
		boolean accountNonExpired=true;
		boolean credentialsNonExpired=true;
		boolean accountNonLocked=true;
		
		UserDetails userDetails=(UserDetails) new User(user.getEmail(),user.getPassword(),enabled,accountNonExpired,credentialsNonExpired,accountNonLocked,grantList);
		return userDetails;
	}
}
