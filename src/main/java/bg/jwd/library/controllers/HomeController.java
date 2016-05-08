package bg.jwd.library.controllers;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.library.utils.UserUtils;

@Controller
public class HomeController {
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		model.addAttribute("username", UserUtils.getUser().getUsername());
		
		return "home";
	}
	
}
