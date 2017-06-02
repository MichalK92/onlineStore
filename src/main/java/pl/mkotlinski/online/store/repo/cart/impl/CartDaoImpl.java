package pl.mkotlinski.online.store.repo.cart.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import pl.mkotlinski.online.store.model.cart.Cart;
import pl.mkotlinski.online.store.model.product.Product;
import pl.mkotlinski.online.store.model.user.UserAccount;
import pl.mkotlinski.online.store.repo.abstractDao.AbstractDao;
import pl.mkotlinski.online.store.repo.cart.CartDao;

@Repository("cartDaoRepo")
public class CartDaoImpl extends AbstractDao<Long, Cart> implements CartDao
{
	@Override
	public Cart addProductToCart(Cart cart, Product product)
	{
		cart.getProductList().add(product);
		merge(cart);
		return cart;
	}

	@Override
	public Cart addProductsToCart(Cart cart, List<Product> products)
	{
		return null;
	}
}
