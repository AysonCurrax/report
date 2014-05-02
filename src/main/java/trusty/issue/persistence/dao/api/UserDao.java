package trusty.issue.persistence.dao.api;

import java.util.List;

import trusty.issue.persistence.domain.User;

public interface UserDao {
	List<User> getAllUsers();
	String getUserName(String id);
	void addUser(User user);
	void updateUser(User user);
	boolean userExists(String id);
}
