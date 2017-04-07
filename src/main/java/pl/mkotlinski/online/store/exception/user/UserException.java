package pl.mkotlinski.online.store.exception.user;

import pl.mkotlinski.online.store.exception.WebApplicationException;

abstract public class UserException extends WebApplicationException
{
	private static final long serialVersionUID = 1L;
			
	public UserException(String message)
	{
		super(message);
	}
	
}
