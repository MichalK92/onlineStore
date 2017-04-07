package pl.mkotlinski.online.store.exception.handler.global;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import pl.mkotlinski.online.store.MainController;
import pl.mkotlinski.online.store.exception.user.UserExistsException;

@ControllerAdvice
public class GlobalExceptionHandler
{
	private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(UserExistsException.class)
	public ModelAndView handleUserExistsExcetpion(HttpServletRequest request, Exception ex)
	{
		ModelAndView mnv = new ModelAndView("redirect:/404");
		
		logger.error("User Exists Exception: " + ex);
		
		FlashMap outputFlashMap = RequestContextUtils.getOutputFlashMap(request);	
		//Redirect model 
		outputFlashMap.put("test", "test");		
		return mnv;
	}
}
