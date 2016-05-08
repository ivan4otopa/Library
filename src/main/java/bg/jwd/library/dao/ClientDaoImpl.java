package bg.jwd.library.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bg.jwd.library.entities.Client;

@Repository
public class ClientDaoImpl implements ClientDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Client> getClients() {
		Criteria criteria = sessionFactory.openSession().createCriteria(Client.class);
		
		return criteria.list();
	}

	@Transactional
	@Override
	public boolean addClient(Client client) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(client);
		tx.commit();
		session.close();
		
		return true;
	}

	@Transactional
	@Override
	public boolean editClient(Client client) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.update(client);
		tx.commit();
		session.close();
		
		return true;
	}

	@Override
	public boolean deleteClient(long id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("delete Client where id = :id");
		
		query.setParameter("id", id);
		query.executeUpdate();
		session.close();
		
		return true;
	}

	@Override
	public List<Client> searchClients(String criteria, String value) {
		Session session = sessionFactory.openSession();
		Query query = null;
		
		if (criteria.equals("name")) {
			query = session.createQuery("from Client where name = :name");
		} else if (criteria.equals("pid")) {
			query = session.createQuery("from Client where pid = :pid");
		} else {
			query = session.createQuery("from Client where date_of_birth = :dateOfBirth");
		}
		
		if (criteria.equals("dateOfBirth")) {		
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat dbFormat = new SimpleDateFormat("dd-MMM-yy");
			Date date = null;
			
			try {
				date = format.parse(value);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			query.setParameter("dateOfBirth", dbFormat.format(date));
		} else {
			query.setParameter(criteria, value);
		}
		
		List<Client> clients = query.list();
		
		session.close();
		
		return clients;
	}
}
