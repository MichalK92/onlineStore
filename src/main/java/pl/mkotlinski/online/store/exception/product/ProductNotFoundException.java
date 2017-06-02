package pl.mkotlinski.online.store.exception.product;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Product not found.")
public class ProductNotFoundException extends ProductException
{
	public ProductNotFoundException(String message)
	{
		super(message);
	}
	
	public ProductNotFoundException(long id_product)
	{
		super("Brak produktu o id: " + id_product);
	}

}
