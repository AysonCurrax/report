package trusty.issue.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import trusty.issue.persistence.dao.api.UserDao;
import trusty.issue.persistence.domain.User;

@Repository
public class UserDaoImpl implements UserDao{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<User> getAllUsers() {
		List<User> result = new ArrayList<User>();
		TypedQuery<User> query = em.createQuery("select u from User u", User.class);
		result = query.getResultList();
		return result;
	}
	
	@Override
	public String getUserName(String id) {
		User user = em.find(User.class, id);
		return user.getName();
	}
	
	@Override
	@Transactional
	public void addUser(User user) {
		User u = em.find(User.class, user.getId());
		if(u == null) {
			em.persist(user);
			em.flush();
		}
	}
	
	@Override
	@Transactional
	public void updateUser(User user) {
		User u = em.find(User.class, user.getId());
		u.setName(user.getName());
		em.merge(u);
		em.flush();
	}
	
	@Override
	public boolean userExists(String id) {
		User u = em.find(User.class, id);
		if(u == null) {
			return false;
		}
		else {
			return true;
		}
	}
}
