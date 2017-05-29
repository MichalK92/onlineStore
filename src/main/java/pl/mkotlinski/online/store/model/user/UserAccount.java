package pl.mkotlinski.online.store.model.user;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pl.mkotlinski.online.store.model.cart.Cart;
import pl.mkotlinski.online.store.model.order.UserOrder;

@Entity
@Table(name = "USER_ACCOUNT")
public class UserAccount
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@Column(name = "LOGIN", unique = true)
	private String login;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "PASSWORD")
	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USER_ACCOUNT_ROLE", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "USER_PROFILE_ID") })
	private Set<UserRole> roles = new HashSet<UserRole>();

	@OneToOne( fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ID_CART")
	private Cart cart;

	@OneToMany(mappedBy = "userAccount")
	private List<UserOrder> orders;

	public UserAccount()
	{

	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getLogin()
	{
		return login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	public Set<UserRole> getRoles()
	{
		return roles;
	}

	public void setRoles(Set<UserRole> roles)
	{
		this.roles = roles;
	}

	public Cart getCart()
	{
		return cart;
	}

	public void setCart(Cart cart)
	{
		this.cart = cart;
	}

	public List<UserOrder> getOrders()
	{
		return orders;
	}

	public void setOrders(List<UserOrder> orders)
	{
		this.orders = orders;
	}

	@Override
	public String toString()
	{
		return "UserAccount [id=" + id + ", login=" + login + ", userName=" + userName + ", password=" + password
				+ ", roles=" + roles + ", cart=" + getCart() + ", orders=" + orders + "]";
	}



}
