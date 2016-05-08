package bg.jwd.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.library.entities.Client;
import bg.jwd.library.services.ClientService;

@Controller
public class ClientsController {
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value = "/clientRegistry", method = RequestMethod.GET)
	public String getClientRegistryPage(Model model) {
		model.addAttribute("clients", clientService.getClients());
		
		return "clients/clientRegistry";
	}
	
	@RequestMapping(value = "/addClient", method = RequestMethod.GET)
	public String getAddClientPage() {
		return "clients/addClient";
	}
	
	@RequestMapping(value = "/addClient", method = RequestMethod.POST)
	public String addClient(@ModelAttribute("client") Client client) {
		clientService.addClient(client);
		
		return "redirect:/clientRegistry";
	}
	
	@RequestMapping(value = "/editClient", method = RequestMethod.GET)
	public String getEditClientPage() {
		return "clients/editClient";
	}
	
	@RequestMapping(value = "/editClient", method = RequestMethod.POST)
	public String editClient(@ModelAttribute("client") Client client) {
		clientService.editClient(client);
		
		return "redirect:/clientRegistry";
	}
	
	@RequestMapping(value = "/deleteClient", method = RequestMethod.GET)
	public String getDeleteClientPage() {
		return "clients/deleteClient";
	}
	
	@RequestMapping(value = "/deleteClient", method = RequestMethod.POST)
	public String deleteClient(long id) {
		clientService.deleteClient(id);
				
		return "redirect:/clientRegistry";
	}
	
	@RequestMapping(value = "/searchClients", method = RequestMethod.GET)
	public String getSearchClientsPage() {
		return "clients/searchClients";
	}
	
	@RequestMapping(value = "/searchClients", method = RequestMethod.POST)
	public String searchClients(Model model, String criteria, String value) {
		model.addAttribute("clients", clientService.searchClients(criteria, value));
				
		return "clients/clientRegistry";
	}
}
