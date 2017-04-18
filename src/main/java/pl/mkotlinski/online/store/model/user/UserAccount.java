package pl.mkotlinski.online.store.model.user;

import java.util.HashSet;
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
import javax.persistence.Table;

@Entity
@Table(name = "USER_ACCOUNT")
public class UserAccount
{

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;

	@Column(unique = true)
	private String login;

	private String userName;

	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USER_ACCOUNT_ROLE", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "USER_PROFILE_ID") })
	private Set<UserProfile> roles = new HashSet<UserProfile>();
	
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

	public Set<UserProfile> getRoles()
	{
		return roles;
	}

	public void setRoles(Set<UserProfile> roles)
	{
		this.roles = roles;
	}

	@Override
	public String toString()
	{
		return "UserAccount [id=" + id + ", login=" + login + ", userName=" + userName + ", roles=" + roles + "]";
	}

}
