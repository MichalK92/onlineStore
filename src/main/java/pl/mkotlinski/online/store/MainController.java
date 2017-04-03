package pl.mkotlinski.online.store;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping(value = "/")
	public String defaultPage()
	{
		return "index";
	}
}
