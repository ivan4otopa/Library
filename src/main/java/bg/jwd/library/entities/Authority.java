package bg.jwd.library.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "authorities")
public class Authority {
	@Id
	@GenericGenerator(name="generator", strategy="increment")
    @GeneratedValue(generator="generator")
	private long id;
	private String name;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "users_authorities", joinColumns = {
			@JoinColumn(name = "authority_id", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name ="user_id", nullable = false, updatable = false) })
	private Set<User> users = new HashSet<>();
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<User> getUsers() {
		return users;
	}
	
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	public void addUser(User user) {
		getUsers().add(user);
		user.getApplicationAuthorities().add(this);
	}
}
