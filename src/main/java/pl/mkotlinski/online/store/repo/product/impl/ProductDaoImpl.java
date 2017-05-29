package pl.mkotlinski.online.store.repo.product.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import pl.mkotlinski.online.store.model.product.Product;
import pl.mkotlinski.online.store.repo.abstractDao.AbstractDao;
import pl.mkotlinski.online.store.repo.product.ProductDao;

@Repository("productDaoRepo")
public class ProductDaoImpl extends AbstractDao<Long, Product> implements ProductDao
{
	@Override
	public void addNewProduct(Product product)
	{
		persist(product);
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
		return getByPrimaryKey(id_product);
	}

}
