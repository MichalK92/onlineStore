package pl.mkotlinski.online.store.exception.product;

import pl.mkotlinski.online.store.exception.WebApplicationException;

public class ProductException extends WebApplicationException
{
	private static final long serialVersionUID = 1L;

	public ProductException(String message)
	{
		super(message);
	}

}
