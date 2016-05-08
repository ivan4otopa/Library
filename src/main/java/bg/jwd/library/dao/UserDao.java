package bg.jwd.library.dao;

import java.util.List;

import bg.jwd.library.entities.User;

public interface UserDao {
	List<User> getUsers();
	
	boolean addUser(User user, boolean isAdmin);
	
	boolean editUser(User user, String hiddenUsername);
	
	boolean deactivateUser(long id);
	
	List<User> searchUsers(String criteria, String value);
}
