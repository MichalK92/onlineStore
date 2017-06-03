package pl.mkotlinski.online.store.controller;

import static org.hamcrest.CoreMatchers.instanceOf;

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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.mkotlinski.online.store.exception.user.UserExistsException;
import pl.mkotlinski.online.store.exception.user.UserNotLoggedException;
import pl.mkotlinski.online.store.model.cart.Cart;
import pl.mkotlinski.online.store.model.form.UserAccountForm;
import pl.mkotlinski.online.store.model.product.Product;
import pl.mkotlinski.online.store.service.UserRoleService;
import pl.mkotlinski.online.store.service.UserService;
import pl.mkotlinski.online.store.service.cart.CartService;
import pl.mkotlinski.online.store.service.product.ProductService;
import pl.mkotlinski.online.store.utils.SystemUtils;
import pl.mkotlinski.online.store.validator.UserFormValidator;

@Controller
public class MainController
{
	private static final Logger logger = Logger.getLogger(MainController.class);

	@Autowired
	private ProductService productService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserRoleService userRoleService;

	@Autowired
	private CartService cartService;

	@Autowired
	private UserFormValidator userFormValidator;

	@Autowired
	private SystemUtils systemUtils;

	@InitBinder
	private void initBinding(WebDataBinder binder)
	{
		if (binder.getTarget() instanceof Cart)
		{
			return;
		}
		binder.setValidator(userFormValidator);
	}
	@ModelAttribute("testKoszyk")
	public Cart sessionShopCart() throws UserNotLoggedException
	{
		if (systemUtils.isUserLogged())
		{
			return userService.findByLogin(systemUtils.getLoggedUserLogin()).getCart();
		}
		return null;
	}

	@RequestMapping(value = "/")
	public ModelAndView defaultPage() throws UserExistsException, UserNotLoggedException
	{
		ModelAndView mnv = new ModelAndView();
		mnv.addObject("productList", productService.getAllProducts());
		mnv.setViewName("index");
		return mnv;
	}

	// LOGIN && Logout [START]

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(Model model)
	{
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("login/loginPage");
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
		UserAccountForm userAccountForm = new UserAccountForm();
		model.addAttribute("userAccountForm", userAccountForm);

		mnv.setViewName("registerUser/registerUser");
		return mnv;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerUserPOST(Model model,
			@ModelAttribute("userAccountForm") @Validated UserAccountForm userAccountForm, BindingResult bindingResult)
			throws UserExistsException
	{
		ModelAndView mnv = new ModelAndView();

		if (bindingResult.hasErrors())
		{
			mnv.setViewName("registerUser/registerUser");
			return mnv;
		}
		if (userService.findByLogin(userAccountForm.getLogin()) != null)
		{
			model.addAttribute("userExistError", "userExistError");
			mnv.setViewName("registerUser/registerUser");
			return mnv;
		}
		userService.addUser(userAccountForm.getUser());
		mnv.setViewName("index");
		return mnv;
	}

	// REGISTER USER [END]

	// ERROR PAGE [START]

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accessDenied(Model model, Principal principal)
	{
		ModelAndView mnv = new ModelAndView();

		mnv.setViewName("error/accessDenied");
		return mnv;
	}

	@RequestMapping(value = "/404")
	public ModelAndView notFound(Model model, Principal principal)
	{
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("error/errorPage404");
		return mnv;
	}

	// ERROR PAGE [END]
	private void test()
	{
		Product product = new Product();
		product.setProductName("P1");
		Product product2 = new Product();
		product2.setProductName("P2");

		productService.addNewProduct(product);
		productService.addNewProduct(product2);
	}

	private void test2() throws UserNotLoggedException
	{
		//System.out.println("Login" + systemUtils.getLoggedUser().getLogin());
		// Product product = productService.getProductById(3);
		// UserAccount userAccount =
		// userService.findByLogin(SystemUtils.getLoggedUserLogin());
		// System.out.println(userAccount.getCart().getProductList());
		// cartService.addProductToCart(userAccount.getCart(), product);
	}
}
