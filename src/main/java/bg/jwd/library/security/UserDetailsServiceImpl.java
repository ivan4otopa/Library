package bg.jwd.library.security;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import bg.jwd.library.entities.Authority;
import bg.jwd.library.entities.User;

public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<GrantedAuthority> authorities = new ArrayList<>();
		Criteria criteria = sessionFactory.openSession().createCriteria(User.class);
		
		criteria.add(Restrictions.eqOrIsNull("username", username));
		
		User user = (User)criteria.uniqueResult();
		
		for (Authority authority : user.getApplicationAuthorities()) {
			authorities.add(new SimpleGrantedAuthority(authority.getName()));
		}
		
		return new User(username, user.getPassword(), authorities);
	}
}
