package trusty.issue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trusty.issue.persistence.dao.api.IssueDao;
import trusty.issue.persistence.dao.api.TypeDao;
import trusty.issue.persistence.dao.api.UserDao;
import trusty.issue.persistence.domain.Issue;
import trusty.issue.persistence.domain.Type;
import trusty.issue.persistence.domain.User;
import trusty.issue.service.api.ServiceFacade;
import trusty.issue.service.api.UserService;

@Service
public class ServiceFacadeImpl implements ServiceFacade{

	@Autowired
	IssueDao issueDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	TypeDao typeDao;
	
	@Autowired
	UserService userService;
	
	@Override
	public List<Issue> getAllIssues() {
		return issueDao.getAllIssues();
	}
	
	@Override
	public void addIssue(Issue issue) {
		issueDao.addIssue(issue);
	}
	
	@Override
	public int getEntryCount() {
		return issueDao.getEntryCount();
	}
	
	@Override
	public List<User> getAllUsers()  {
		return userDao.getAllUsers();
	}
	
	@Override
	public String getUserName(String id) {
		return userDao.getUserName(id);
	}
	
	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}
	
	@Override
	public void checkUser(String id) {
		User user = new User();
		user.setId(id);
		user.setName(userService.getUserNameBySteamId(id));
		if(!userDao.userExists(id)) {
			userDao.addUser(user);
		}
	}
	
	@Override
	public List<Type> getAllTypes() {
		return typeDao.getAllTypes();
	}
}
