package pl.mkotlinski.online.store.exception.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User not found.")
public class UserNotFoundException extends UserException
{
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String message)
	{
		super(message);
	}
	
	public UserNotFoundException(long id_user)
	{
		super(String.valueOf(id_user));
	}
}
