package pl.mkotlinski.online.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pl.mkotlinski.online.store.exception.user.UserExistsException;
import pl.mkotlinski.online.store.exception.user.UserNotLoggedException;
import pl.mkotlinski.online.store.model.cart.Cart;
import pl.mkotlinski.online.store.service.UserService;
import pl.mkotlinski.online.store.utils.SystemUtils;

@Controller
public class CartController
{
	@Autowired
	private UserService userService;
	
	@Autowired
	private SystemUtils systemUtils;
	

	
}
