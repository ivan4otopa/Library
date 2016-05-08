package bg.jwd.library.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bg.jwd.library.entities.Book;

@Repository
public class BookDaoImpl implements BookDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Book> getBooks() {
		Criteria criteria = sessionFactory.openSession().createCriteria(Book.class);

		return criteria.list();
	}

	@Transactional
	@Override
	public boolean addBook(Book book) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(book);
		tx.commit();
		session.close();
		
		return true;
	}

	@Transactional
	@Override
	public boolean editBook(Book book) {		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.update(book);
		tx.commit();
		session.close();
		
		return true;
	}

	@Override
	public boolean deleteBook(long id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("delete Book where id = :id");
		
		query.setParameter("id", id);
		query.executeUpdate();
		session.close();
		
		return true;
	}
	
	@Override
	public List<Book> searchBooks(String criteria, String value) {
		Session session = sessionFactory.openSession();
		Query query = null;
		
		if (criteria.equals("name")) {
			query = session.createQuery("from Book where name = :name");
		} else if (criteria.equals("author")) {
			query = session.createQuery("from Book where author = :author");
		} else {
			query = session.createQuery("from Book where year_of_publishing = :yearOfPublishing");			
		}
		
		query.setParameter(criteria, value);	
		
		List<Book> books = query.list();
		
		session.close();
		
		return books;
	}
}
