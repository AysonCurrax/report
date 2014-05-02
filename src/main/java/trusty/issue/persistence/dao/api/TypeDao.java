package trusty.issue.persistence.dao.api;

import java.util.List;

import trusty.issue.persistence.domain.Type;

public interface TypeDao {
	List<Type> getAllTypes();
}
