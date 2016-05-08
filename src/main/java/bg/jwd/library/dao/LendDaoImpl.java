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

import bg.jwd.library.entities.Lend;

@Repository
public class LendDaoImpl implements LendDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Lend> getLends() {
		Criteria criteria = sessionFactory.openSession().createCriteria(Lend.class);

		return criteria.list();
	}

	@Override
	public boolean addLend(Lend lend) {		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(lend);
		tx.commit();
		session.close();
		
		return true;
	}

	@Override
	public boolean editLend(Lend lend) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.update(lend);
		tx.commit();
		session.close();
		
		return true;
	}
	
	@Override
	public boolean deleteLend(long id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("delete Lend where id = :id");
		
		query.setParameter("id", id);
		query.executeUpdate();
		session.close();
		
		return true;
	}

	@Override
	public List<Lend> searchLends(String criteria, String value) {
		Session session = sessionFactory.openSession();
		Query query = null;
		
		if (criteria.equals("bookId")) {
			query = session.createQuery("from Lend where book_id = :bookId");
		} else if (criteria.equals("clientName")) {
			query = session.createQuery("select l from Lend l join l.client c where c.name = :clientName");
		} else if (criteria.equals("dateOfLending")) {			
			query = session.createQuery("from Lend where date_of_lending = :dateOfLending");
		} else {
			query = session.createQuery("from Lend where date_of_return = :dateOfReturn");
		}
		
		if (criteria.equals("dateOfLending") || criteria.equals("dateOfReturn")) {		
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat dbFormat = new SimpleDateFormat("dd-MMM-yy");
			Date date = null;
			
			try {
				date = format.parse(value);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			query.setParameter(criteria, dbFormat.format(date));			
		} else {			
			query.setParameter(criteria, value);
		}
		
		List<Lend> lends = query.list();
		
		session.close();
		
		return lends;
	}

	@Override
	public boolean addReturnDate(long id, String returnDate) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dbFormat = new SimpleDateFormat("dd-MMM-yy");
		Date date = null;
		
		try {
			date = format.parse(returnDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Session session = sessionFactory.openSession();
		Query query = session.createQuery("update Lend set date_of_return = :dateOfReturn where id = :id");
		
		query.setParameter("dateOfReturn", dbFormat.format(date));
		query.setParameter("id", id);
		query.executeUpdate();
		session.close();
		
		return true;
	}	
}
