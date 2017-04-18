package pl.mkotlinski.online.store.service;

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

import pl.mkotlinski.online.store.model.user.UserAccount;
import pl.mkotlinski.online.store.model.user.UserProfile;

@Service("storeUserDetailsService")
public class ApplicationUserDetailsService implements UserDetailsService
{
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String ssoId) throws UsernameNotFoundException
	{
		UserAccount userAccount = userService.findByLogin(ssoId);
		if(userAccount == null)
		{
			throw new UsernameNotFoundException("Username not found");			
		}

		return new User(userAccount.getLogin(), userAccount.getPassword(), true, true, true, true,
				getGrantedAuthorities(userAccount));
	}

	private List<GrantedAuthority> getGrantedAuthorities(UserAccount userAccount)
	{
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for(UserProfile userProfile : userAccount.getRoles())
		{
			authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getRole()));
		}		
		return authorities;
	}

}
