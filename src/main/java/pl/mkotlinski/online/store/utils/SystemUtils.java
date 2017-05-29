package pl.mkotlinski.online.store.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import pl.mkotlinski.online.store.model.user.UserAccount;
import pl.mkotlinski.online.store.service.UserService;

@Component
@Scope(scopeName = BeanDefinition.SCOPE_SINGLETON)
public class SystemUtils
{
	@Autowired
	private UserService userService;
	
	public UserAccount getLoggedUser()
	{
		return userService.findByLogin(getLoggedUserLogin());
	}
	
	public String getLoggedUserLogin()
	{
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
}
