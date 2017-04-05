package pl.mkotlinski.online.store.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("customUserdetailsService")
public class CustomUserDetailsService implements UserDetailsService
{

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	 private List<GrantedAuthority> getGrantedAuthorities(){
		 List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		 
		 return authorities;
	 }
	
}
