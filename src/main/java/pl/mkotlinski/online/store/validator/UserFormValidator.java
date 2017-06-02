package pl.mkotlinski.online.store.validator;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pl.mkotlinski.online.store.model.form.UserAccountForm;

@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class UserFormValidator implements Validator
{

	@Override
	public boolean supports(Class<?> paramClass)
	{
		return UserAccountForm.class.isAssignableFrom(paramClass);
	}

	@Override
	public void validate(Object target, Errors errors)
	{

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "userFormValidator.login.null");
		//errors.rejectValue("password", "userFormValidator.password.notEquals");
	}
	
}
