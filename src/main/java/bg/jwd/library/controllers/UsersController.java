package bg.jwd.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.library.entities.User;
import bg.jwd.library.services.UserService;
import bg.jwd.library.utils.UserUtils;

@Controller
public class UsersController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/userRegistry", method = RequestMethod.GET)
	public String getUserRegistryPage(Model model) {
		model.addAttribute("users", userService.getUsers());
		
		return "users/userRegistry";
	}
	
	@Secured({ "ROLE_ADMIN" })
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String getAddUserPage() {
		return "users/addUser";
	}
	
	@Secured({ "ROLE_ADMIN" })
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user, boolean isAdmin) {
		userService.addUser(user, isAdmin);
		
		return "redirect:/userRegistry";
	}
	
	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	public String getEditUserPage(Model model) {
		model.addAttribute("hiddenUsername", UserUtils.getUser().getUsername());
		
		return "users/editUser";
	}
	
	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	public String editUser(@ModelAttribute("user") User user, String hiddenUsername) {
		userService.editUser(user, hiddenUsername);
		
		return "redirect:/userRegistry";
	}
	
	@Secured({ "ROLE_ADMIN" })
	@RequestMapping(value = "/deactivateUser", method = RequestMethod.GET)
	public String getDeactivateUserPage() {
		return "users/deactivateUser";
	}
	
	@Secured({ "ROLE_ADMIN" })
	@RequestMapping(value = "/deactivateUser", method = RequestMethod.POST)
	public String deactivateUser(long id) {
		userService.deactivateUser(id);
				
		return "redirect:/userRegistry";
	}
	
	@Secured({ "ROLE_ADMIN" })
	@RequestMapping(value = "/searchUsers", method = RequestMethod.GET)
	public String getSearchUsersPage() {
		return "users/searchUsers";
	}
	
	@Secured({ "ROLE_ADMIN" })
	@RequestMapping(value = "/searchUsers", method = RequestMethod.POST)
	public String searchUsers(Model model, String criteria, String value) {
		model.addAttribute("users", userService.searchUsers(criteria, value));
				
		return "users/userRegistry";
	}
}
