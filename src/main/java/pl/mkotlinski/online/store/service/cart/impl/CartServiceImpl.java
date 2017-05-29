package pl.mkotlinski.online.store.service.cart.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mkotlinski.online.store.model.cart.Cart;
import pl.mkotlinski.online.store.model.product.Product;
import pl.mkotlinski.online.store.repo.cart.CartDao;
import pl.mkotlinski.online.store.service.cart.CartService;

@Service("cartService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
@Transactional
public class CartServiceImpl implements CartService
{
	@Autowired
	private CartDao cartDao;
	
	@Override
	public Cart addProductToCart(Cart cart, Product product)
	{
		return cartDao.addProductToCart(cart, product);
	}

	@Override
	public Cart addProductsToCart(Cart cart, List<Product> products)
	{
		return cartDao.addProductsToCart(cart, products);
	}

}
