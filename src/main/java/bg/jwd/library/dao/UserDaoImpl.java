package bg.jwd.library.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bg.jwd.library.entities.Authority;
import bg.jwd.library.entities.User;
import bg.jwd.library.utils.MD5;
import bg.jwd.library.utils.UserUtils;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<User> getUsers() {
		Criteria criteria = sessionFactory.openSession().createCriteria(User.class);
		
		return criteria.list();
	}

	@Transactional
	@Override
	public boolean addUser(User user, boolean isAdmin) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();									
		
		user.setPassword(new MD5().crypt(user.getPassword()));
		user.setStatus("Active");

		Criteria userAuthorityCriteria = session.createCriteria(Authority.class);
		
		userAuthorityCriteria.add(Restrictions.eq("name", "ROLE_USER"));
		
		Authority userAuthority = (Authority) userAuthorityCriteria.uniqueResult();
		
		if (isAdmin) {
			Criteria adminAuthorityCriteria = session.createCriteria(Authority.class);
			
			adminAuthorityCriteria.add(Restrictions.eq("name", "ROLE_ADMIN"));
			
			Authority adminAuthority = (Authority) adminAuthorityCriteria.uniqueResult();
			
			adminAuthority.addUser(user);
		}
		
		userAuthority.addUser(user);
		session.save(user);
		tx.commit();
		session.close();
		
		return true;
	}

	@Transactional
	@Override
	public boolean editUser(User user, String hiddenUsername) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("select id from User where username = :username");
		
		query.setParameter("username", UserUtils.getUser().getUsername());
		
		UserUtils.getUser().setUsername(user.getUsername());
		
		user.setId((long) query.uniqueResult());
		user.setPassword(MD5.crypt(user.getPassword()));
		user.setStatus("Active");
		session.update(user);
		tx.commit();
		session.close();
		
		return true;
	}

	@Override
	public boolean deactivateUser(long id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("update User set status = 'Inactive' where id = :id");
		
		query.setParameter("id", id);
		query.executeUpdate();
		session.close();
		
		return true;
	}

	@Override
	public List<User> searchUsers(String criteria, String value) {
		Session session = sessionFactory.openSession();
		Query query = null;
		
		if (criteria.equals("username")) {
			query = session.createQuery("from User where username = :username");
		} else if (criteria.equals("name")) {
			query = session.createQuery("from User where name = :name");
		} else if (criteria.equals("type")) {
			query = session.createQuery("select u from User u join u.applicationAuthorities a where a.name = :type");
		} else {
			query = session.createQuery("from User where status = :status");
		}
		
		if (criteria.equals("type")) {		
			query.setParameter(criteria, "ROLE_" + value.toUpperCase());
		} else {
			query.setParameter(criteria, value);
		}
		
		List<User> users = query.list();
		
		return users;
	}
}
