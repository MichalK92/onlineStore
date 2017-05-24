package pl.mkotlinski.online.store.exception.handler.global;

import java.net.BindException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import pl.mkotlinski.online.store.exception.user.UserExistsException;

@ControllerAdvice
public class GlobalExceptionHandler
{
	private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);
	private static final String REDIRECT_404 = "redirect:/404";
	
	@ExceptionHandler(UserExistsException.class)
	public ModelAndView handleUserExistsExcetpion(HttpServletRequest request, Exception ex)
	{
		ModelAndView mnv = new ModelAndView(REDIRECT_404);		
		logger.error("User Exists Exception: " + ex);		
		FlashMap outputFlashMap = RequestContextUtils.getOutputFlashMap(request);	
		outputFlashMap.put("test", "test");		
		return mnv;
	}

	@ExceptionHandler(BindException.class)
	public ModelAndView handlerBindException(HttpServletRequest request, Exception ex)
	{
		ModelAndView mnv = new ModelAndView();
		ex.printStackTrace();
		return mnv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(HttpServletRequest request, Exception ex)
	{
		ModelAndView mnv = new ModelAndView();
		ex.printStackTrace();
		return mnv;
	}
	
	/*
	@ExceptionHandler(Exception.class)
	public ModelAndView exception(HttpServletRequest request, Exception ex)
	{
		ModelAndView mnv = new ModelAndView(REDIRECT_404);
		logger.error(ex);		
		return mnv;
	}*/
}
