package pl.mkotlinski.online.store.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;

@Entity
public class UserAccount
{

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;

	@Column(unique = true)
	private String login;

	private String userName;

	private String password;

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

	@Override
	public String toString()
	{
		return "UserAccount [id=" + id + ", login=" + login + ", userName=" + userName + ", password=" + password + "]";
	}

}
