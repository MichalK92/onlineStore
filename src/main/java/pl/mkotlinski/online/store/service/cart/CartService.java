package pl.mkotlinski.online.store.service.cart;

import java.util.List;

import pl.mkotlinski.online.store.model.cart.Cart;
import pl.mkotlinski.online.store.model.product.Product;
import pl.mkotlinski.online.store.model.user.UserAccount;

public interface CartService
{
	public Cart addProductToCart(Cart cart, Product product);
	public Cart addProductsToCart(Cart cart, List<Product> products);
}
