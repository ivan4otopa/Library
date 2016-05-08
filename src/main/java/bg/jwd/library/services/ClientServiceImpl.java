package bg.jwd.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.jwd.library.dao.ClientDao;
import bg.jwd.library.entities.Client;

@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	private ClientDao clientDao;
	
	@Override
	public List<Client> getClients() {
		return clientDao.getClients();
	}

	@Override
	public boolean addClient(Client client) {
		return clientDao.addClient(client);
	}

	@Override
	public boolean editClient(Client client) {
		return clientDao.editClient(client);
	}

	@Override
	public boolean deleteClient(long id) {
		return clientDao.deleteClient(id);
	}

	@Override
	public List<Client> searchClients(String criteria, String value) {
		return clientDao.searchClients(criteria, value);
	}
}
