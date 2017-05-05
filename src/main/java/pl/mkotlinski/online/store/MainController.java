package pl.mkotlinski.online.store;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.mkotlinski.online.store.exception.user.UserExistsException;
import pl.mkotlinski.online.store.model.form.UserAccountForm;
import pl.mkotlinski.online.store.model.user.UserAccount;
import pl.mkotlinski.online.store.model.user.UserRoleTypeEnum;
import pl.mkotlinski.online.store.service.UserRoleService;
import pl.mkotlinski.online.store.service.UserService;

@Controller
public class MainController
{
	private static final Logger logger = Logger.getLogger(MainController.class);

	@InitBinder
	private void initBinding(WebDataBinder binder)
	{
		
	}
	
	@Autowired
	private UserService userService;

	@Autowired
	UserRoleService userRoleService;

	@RequestMapping(value = "/")
	public ModelAndView defaultPage() throws UserExistsException
	{
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("layout/layout");
	//	test();
		return mnv;
	}
	
	@RequestMapping(value = "/test")
	public ModelAndView testThymeleaf() throws UserExistsException
	{
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("layout/test");
	//	test();
		return mnv;
	}

	// LOGIN && Logout [START]

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(Model model)
	{
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("login");
		return mnv;
	}

	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public ModelAndView userInfo(Model model)
	{
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("userInfo");

		String principalString = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		mnv.addObject("principal", principalString);
		return mnv;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null)
		{
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}
	// LOGIN && Logout [END]

	// REGISTER USER [BEGIN]

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerUserGET(Model model)
	{
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("registerUser");
		UserAccountForm userAccountForm = new UserAccountForm();
		model.addAttribute("userAccountForm", userAccountForm);
		return mnv;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerUserPOST(Model model)
	{
		ModelAndView mnv = new ModelAndView();
		
		mnv.setViewName("index");		
		return mnv;
	}

	// REGISTER USER [END]

	// ERROR PAGE [START]

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accessDenied(Model model, Principal principal)
	{
		ModelAndView mnv = new ModelAndView();

		mnv.setViewName("errorPage/accessDenied");
		return mnv;
	}

	@RequestMapping(value = "/404")
	public ModelAndView notFound(Model model, Principal principal)
	{
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("errorPage404");
		return mnv;
	}
	// ERROR PAGE [END]

	private void test() throws UserExistsException
	{
		UserAccount userAccount = new UserAccount();
		userAccount.setLogin("michal");
		userAccount.setPassword("test");
		userAccount.getRoles().add(userRoleService.findByName(UserRoleTypeEnum.USER.getUserRole()));
		UserAccount userAccount2 = new UserAccount();
		userAccount2.setLogin("test244");
		userAccount2.setPassword("test");
		userAccount2.getRoles().add(userRoleService.findByName(UserRoleTypeEnum.ADMIN.getUserRole()));
		userAccount2.getRoles().add(userRoleService.findByName(UserRoleTypeEnum.USER.getUserRole()));
		userService.addUser(userAccount);
		//userService.addUser(userAccount2);
	}
}
