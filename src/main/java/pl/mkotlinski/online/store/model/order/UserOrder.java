package pl.mkotlinski.online.store.model.order;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pl.mkotlinski.online.store.model.user.UserAccount;

@Entity
@Table(name = "USER_ORDER")
public class UserOrder
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@ManyToOne
	@JoinColumn(name = "ID_USER")
	private UserAccount userAccount;
	
	@OneToMany(mappedBy = "userOrder")	
	private List<ProductOrder> productOrders;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public UserAccount getUserAccount()
	{
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount)
	{
		this.userAccount = userAccount;
	}
}
