package pl.mkotlinski.online.store.repo.product.impl;

import java.util.List;

import org.hibernate.Session;
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
		Session session = getEntityMenager().unwrap(Session.class);
		List<Product> productList = session.createCriteria(Product.class).list();
		return productList;
	}

	@Override
	public Product getProductById(long id_product)
	{
		return getByPrimaryKey(id_product);
	}

}
