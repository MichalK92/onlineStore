package pl.mkotlinski.online.store.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import pl.mkotlinski.online.store.configuration.ConfigurationTest;
import pl.mkotlinski.online.store.exception.user.UserException;
import pl.mkotlinski.online.store.model.user.UserAccount;
import pl.mkotlinski.online.store.repo.UserDao;
import pl.mkotlinski.online.store.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ConfigurationTest.class })
@WebAppConfiguration
public class UserServiceImplTest
{
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@Autowired
	private UserDao mockUserDao;

	@Before
	public void setUp()
	{
		Mockito.reset(mockUserDao);
		
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void exampleTest() throws UserException
	{	
		//WHEN THEN RETURN
		UserAccount userAccount = mock(UserAccount.class);
		userAccount.setLogin("MK");
		Mockito.when(mockUserDao.findByLogin(userAccount.getLogin())).thenReturn(userAccount);
		//ASSERT
		assertEquals(userAccount, userService.findByLogin(userAccount.getLogin()));
	}
	
	@Test(expected = UserException.class)
	public void addExistingUserTest() throws UserException
	{
		//WHEN THEN RETURN
		UserAccount userAccount = mock(UserAccount.class);
		Mockito.when(mockUserDao.findByLogin(userAccount.getLogin())).thenReturn(userAccount);
		
		//THROW EXCEPTION
		userService.addUser(userAccount);		
	}
	
	@Test
	public void findByLoginTest() throws UserException
	{
		//MOCK WHEN THEN
		UserAccount userAccount = mock(UserAccount.class);
		Mockito.when(mockUserDao.findUserById(userAccount.getId())).thenReturn(userAccount);
		assertEquals(userAccount, userService.findUserById(userAccount.getId()));
	}
	
	@Test(expected = UserException.class)
	public void exceptionfindByLogin() throws UserException
	{
		Mockito.when(mockUserDao.findByLogin("test")).thenReturn(null);
		
		userService.findByLogin("test");
	}
}
