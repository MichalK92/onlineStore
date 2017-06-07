package pl.mkotlinski.online.store.model.cart;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import pl.mkotlinski.online.store.model.product.Product;

@Entity
@Table(name = "CART")
public class Cart
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "PRODUCT_IN_CART", joinColumns = { @JoinColumn(name = "ID_CART") }, inverseJoinColumns = {
			@JoinColumn(name = "ID_PRODUCT") })
	private List<Product> productList = new ArrayList<Product>();

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public List<Product> getProductList()
	{
		return productList;
	}

	public void setProductList(List<Product> productList)
	{
		this.productList = productList;
	}
	
	public Float getTotalPrice()
	{
		Float price = 0.0f;
		
		for(Product p : getProductList())
		{
			price += p.getPrice();
		}
		
		return price;
	}

	@Override
	public String toString()
	{
		return "Cart [id=" + id + ", productList=" + productList + "]";
	}

}
