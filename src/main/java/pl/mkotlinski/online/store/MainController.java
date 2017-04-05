package pl.mkotlinski.online.store;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping(value = "/")
	public ModelAndView defaultPage()
	{
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("index");		
		
		return mnv;
	}
	
	//LOGIN && Logout [START]
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(Model model)
	{
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("login/loginPage");		
		
		return mnv;
	}
	
	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public ModelAndView userInfo(Model model)
	{
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("login/userInfo");		
		
		String principalString = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		mnv.addObject("principal", principalString);
		return mnv;
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";
	}
	
	//LOGIN && Logout [END]
	
	
	
	//ERROR PAGE [START]
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accessDenied(Model model, Principal principal)
	{
		ModelAndView mnv = new ModelAndView();
		
		mnv.setViewName("errorPage/accessDenied");		
		return mnv;
	}
	
	//ERROR PAGE [END]
}
