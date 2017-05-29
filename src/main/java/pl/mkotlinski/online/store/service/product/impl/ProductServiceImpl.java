package pl.mkotlinski.online.store.service.product.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mkotlinski.online.store.model.product.Product;
import pl.mkotlinski.online.store.repo.product.ProductDao;
import pl.mkotlinski.online.store.service.product.ProductService;

@Service("productService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
@Transactional
public class ProductServiceImpl implements ProductService
{
	@Autowired
	private ProductDao productDao;
	
	@Override
	public void addNewProduct(Product product)
	{
		productDao.addNewProduct(product);
		
	}

	@Override
	public List<Product> getAllProducts()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProductById(long id_product)
	{
		return productDao.getProductById(id_product);
	}
	
}
