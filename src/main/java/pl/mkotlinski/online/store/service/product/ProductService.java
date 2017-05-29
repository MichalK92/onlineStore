package pl.mkotlinski.online.store.service.product;

import java.util.List;

import pl.mkotlinski.online.store.model.product.Product;

public interface ProductService
{
	public void addNewProduct(Product product);
	
	public List<Product> getAllProducts();
	
	public Product getProductById(long id_product);
}
