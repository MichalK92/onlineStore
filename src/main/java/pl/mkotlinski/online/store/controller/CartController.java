package pl.mkotlinski.online.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

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
