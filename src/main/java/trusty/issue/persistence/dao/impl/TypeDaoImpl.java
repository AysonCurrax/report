package trusty.issue.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import trusty.issue.persistence.dao.api.TypeDao;
import trusty.issue.persistence.domain.Type;

@Repository
public class TypeDaoImpl implements TypeDao{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Type> getAllTypes() {
		List<Type> result = new ArrayList<Type>();
		TypedQuery<Type> query = em.createQuery("select t from Type t", Type.class);
		result = query.getResultList();
		return result;
	}
}
