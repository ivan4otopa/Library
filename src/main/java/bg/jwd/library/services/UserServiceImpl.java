package bg.jwd.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.jwd.library.dao.UserDao;
import bg.jwd.library.entities.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@Override
	public boolean addUser(User user, boolean isAdmin) {
		return userDao.addUser(user, isAdmin);
	}

	@Override
	public boolean editUser(User user, String hiddenUsername) {
		return userDao.editUser(user, hiddenUsername);
	}

	@Override
	public boolean deactivateUser(long id) {
		return userDao.deactivateUser(id);
	}

	@Override
	public List<User> searchUsers(String criteria, String value) {
		return userDao.searchUsers(criteria, value);
	}
}
