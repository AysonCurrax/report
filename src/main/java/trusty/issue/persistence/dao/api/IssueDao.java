package trusty.issue.persistence.dao.api;

import java.util.List;

import trusty.issue.persistence.domain.Issue;

public interface IssueDao {
	List<Issue> getAllIssues();
	void addIssue(Issue issue);
	int getEntryCount();
}
