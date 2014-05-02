package trusty.issue.service.api;

import java.util.List;

import trusty.issue.persistence.domain.Issue;
import trusty.issue.persistence.domain.Type;
import trusty.issue.persistence.domain.User;

public interface ServiceFacade {
	List<Issue> getAllIssues();
	void addIssue(Issue issue);
	int getEntryCount();
	List<User> getAllUsers();
	void addUser(User user);
	String getUserName(String id);
	void checkUser(String id);
	List<Type> getAllTypes();
}
