package pl.mkotlinski.online.store.configuration;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.mkotlinski.online.store.repo.UserDao;
import pl.mkotlinski.online.store.service.UserService;
import pl.mkotlinski.online.store.service.impl.UserServiceImpl;

@Configuration
//@ComponentScan(basePackages = "pl.mkotlinski.online.store")
public class ConfigurationTest
{	
	@Bean(name = "mockitoUserDaoService")
	public UserDao mockitoUserDaoService()
	{
		return Mockito.mock(UserDao.class);
	}
	
	@Bean(name = "userService")	
	public UserService getUserService()
	{
		return new UserServiceImpl();
	}
}
