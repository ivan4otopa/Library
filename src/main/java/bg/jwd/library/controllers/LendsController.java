package bg.jwd.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.library.entities.Lend;
import bg.jwd.library.services.LendService;

@Controller
public class LendsController {
	@Autowired
	private LendService lendService;
	
	@RequestMapping(value = "/lendRegistry", method = RequestMethod.GET)
	public String getLendRegistryPage(Model model) {
		model.addAttribute("lends", lendService.getLends());
		
		return "lends/lendRegistry";
	}
	
	@RequestMapping(value = "/addLend", method = RequestMethod.GET)
	public String getAddLendPage() {
		return "lends/addLend";
	}

	@RequestMapping(value = "/addLend", method = RequestMethod.POST)
	public String addLend(@ModelAttribute("lend") Lend lend) {
		lendService.addLend(lend);
		
		return "redirect:/lendRegistry";
	}
	
	@Secured({ "ROLE_ADMIN" })
	@RequestMapping(value = "/editLend", method = RequestMethod.GET)
	public String getEditLendPage() {
		return "lends/editLend";
	}

	@Secured({ "ROLE_ADMIN" })
	@RequestMapping(value = "/editLend", method = RequestMethod.POST)
	public String editLend(@ModelAttribute("lend") Lend lend) {
		lendService.editLend(lend);
		
		return "redirect:/lendRegistry";
	}
	
	@RequestMapping(value = "/deleteLend", method = RequestMethod.GET)
	public String getDeleteLendPage() {
		return "lends/deleteLend";
	}
	
	@RequestMapping(value = "/deleteLend", method = RequestMethod.POST)
	public String deleteLend(long id) {
		lendService.deleteLend(id);
				
		return "redirect:/lendRegistry";
	}
	
	@RequestMapping(value = "/searchLends", method = RequestMethod.GET)
	public String getSearchLendsPage() {
		return "lends/searchLends";
	}
	
	@RequestMapping(value = "/searchLends", method = RequestMethod.POST)
	public String searchLends(Model model, String criteria, String value) {
		model.addAttribute("lends", lendService.searchLends(criteria, value));
				
		return "lends/lendRegistry";
	}
	
	@RequestMapping(value = "/addReturnDate", method = RequestMethod.GET)
	public String getAddReturnDatePage() {				
		return "lends/addReturnDate";
	}
	
	@RequestMapping(value = "/addReturnDate", method = RequestMethod.POST)
	public String addReturnDate(long id, String returnDate) {
		lendService.addReturnDate(id, returnDate);
		
		return "redirect:/lendRegistry";
	}
}
