package trusty.issue.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import trusty.issue.persistence.dao.api.IssueDao;
import trusty.issue.persistence.domain.Issue;

@Repository
public class IssueDaoImpl implements IssueDao{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Issue> getAllIssues() {
		List<Issue> result = new ArrayList<Issue>();
		TypedQuery<Issue> query = em.createQuery("select i from Issue i", Issue.class);
		result = query.getResultList();
		return result;
	}
	
	@Override
	@Transactional
	public void addIssue(Issue issue) {
		Issue i = em.find(Issue.class, issue.getId());
		if(i == null) {
			em.persist(issue);
			em.flush();
		}
	}
	
	@Override
	public int getEntryCount() {
		List<Issue> result = new ArrayList<Issue>();
		TypedQuery<Issue> query = em.createQuery("select i from Issue i", Issue.class);
		result = query.getResultList();
		return result.size();
	}
}
