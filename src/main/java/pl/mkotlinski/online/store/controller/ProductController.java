package pl.mkotlinski.online.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pl.mkotlinski.online.store.exception.product.ProductNotFoundException;
import pl.mkotlinski.online.store.exception.user.UserNotLoggedException;
import pl.mkotlinski.online.store.model.user.UserAccount;
import pl.mkotlinski.online.store.service.cart.CartService;
import pl.mkotlinski.online.store.service.product.ProductService;
import pl.mkotlinski.online.store.utils.StaticStringValue;
import pl.mkotlinski.online.store.utils.SystemUtils;

@Controller
@RequestMapping("/product/")
public class ProductController
{
	@Autowired
	private SystemUtils systemUtils;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/{id_product}")
	public ModelAndView productProfile(@PathVariable("id_product") int id_product)
	{
		ModelAndView mnv = new ModelAndView("productProfile/productProfile");

		return mnv;
	}
	
	@RequestMapping("/{id_product}/addToCart")
	public ModelAndView addProductToCart(@PathVariable("id_product") long id_product) throws UserNotLoggedException, ProductNotFoundException
	{
		ModelAndView mnv = new ModelAndView(StaticStringValue.REDIRECT_TO_MAIN_PAGE);
		if(!systemUtils.isUserLogged())
		{
			throw new UserNotLoggedException();
		}
		//TODO:problem czy inicjalizowaæ karte w UserAccount czy pobraæ karte (raczej inicjalizowaæ
		
		UserAccount userAccount = systemUtils.getLoggedUser();
		
		cartService.addProductToCart(userAccount.getCart(), productService.getProductById(id_product));
		
		return mnv;
	}
}
