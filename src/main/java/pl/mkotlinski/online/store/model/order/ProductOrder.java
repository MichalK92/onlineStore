package pl.mkotlinski.online.store.model.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pl.mkotlinski.online.store.model.product.Product;

@Entity
@Table(name = "PRODUCT_ORDER")
public class ProductOrder
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "ID_USER_ORDER")
	private UserOrder userOrder;
	
	@ManyToOne
	@JoinColumn(name = "ID_PRODUCT")
	private Product product;
}
