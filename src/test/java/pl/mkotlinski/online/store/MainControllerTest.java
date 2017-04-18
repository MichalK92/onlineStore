package pl.mkotlinski.online.store;

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
public class MainControllerTest
{
	private MockMvc mockMvc;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	@Qualifier("mockitoUserDaoService")
	private UserDao userDaoMock;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	/*@Before
	public void setUp()
	{
		Mockito.reset(userDaoMock);
		
		UserAccount userAccount = new UserAccount();
		userAccount.setId(1);
		
		Mockito.when(userDaoMock.findUserById(1)).thenReturn(userAccount);
		
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void test()
	{		
		System.out.println(userService.findUserById(1));
	}*/
}
