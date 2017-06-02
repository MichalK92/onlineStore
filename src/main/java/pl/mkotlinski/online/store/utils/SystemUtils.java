package pl.mkotlinski.online.store.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import pl.mkotlinski.online.store.exception.user.UserNotLoggedException;
import pl.mkotlinski.online.store.model.user.UserAccount;
import pl.mkotlinski.online.store.service.UserService;

@Component
@Scope(scopeName = BeanDefinition.SCOPE_SINGLETON)
public class SystemUtils
{
	@Autowired
	private UserService userService;
	
	public UserAccount getLoggedUser() throws UserNotLoggedException
	{
		return userService.findByLogin(getLoggedUserLogin());
	}
	//TODO:Nie dzia³a jak powinno
	public String getLoggedUserLogin() throws UserNotLoggedException
	{
		String principalName = SecurityContextHolder.getContext().getAuthentication().getName();
		if(principalName.equals(StaticStringValue.ANONYMOUS_USER))
		{
			throw new UserNotLoggedException();
		}
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
	
	public boolean isUserLogged()
	{
		return SecurityContextHolder.getContext().getAuthentication().getName().equals(StaticStringValue.ANONYMOUS_USER) ? false : true;
	}
}
