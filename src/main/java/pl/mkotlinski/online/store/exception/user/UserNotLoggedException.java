package pl.mkotlinski.online.store.exception.user;

import pl.mkotlinski.online.store.exception.WebApplicationException;

public class UserNotLoggedException extends WebApplicationException
{
	private static final String ANONYMOUS_USER = "anonymousUser";
	
	public UserNotLoggedException()
	{
		super(ANONYMOUS_USER);
	}
	
	public UserNotLoggedException(String message)
	{
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
