package pl.mkotlinski.online.store.model.form;

import pl.mkotlinski.online.store.model.user.UserAccount;

public class UserAccountForm
{
	private String login;

	private String firstName;

	private String lastName;

	private String emailAddress;

	private String password;

	private String password2;

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getEmailAddress()
	{
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getPassword2()
	{
		return password2;
	}

	public void setPassword2(String password2)
	{
		this.password2 = password2;
	}

	public String getLogin()
	{
		return login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	public UserAccount getUser()
	{
		// TODO: BUILDER
		UserAccount user = new UserAccount();
		user.setLogin(this.getLogin());
		user.setUserName(this.getFirstName());
		user.setPassword(this.getPassword());
		return user;
	}

}
