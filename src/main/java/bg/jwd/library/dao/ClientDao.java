package bg.jwd.library.dao;

import java.util.List;

import bg.jwd.library.entities.Client;

public interface ClientDao {
	List<Client> getClients();
	
	boolean addClient(Client client);
	
	boolean editClient(Client client);
	
	boolean deleteClient(long id);
	
	List<Client> searchClients(String criteria, String value); 
}
