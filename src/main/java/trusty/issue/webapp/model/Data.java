package trusty.issue.webapp.model;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import trusty.issue.persistence.domain.Type;
import trusty.issue.service.api.ServiceFacade;

@Component
public class Data {

	@Autowired
	ServiceFacade services;
	
	private List<Type> types;
	
	public List<Type> getTypes() {
		return this.types;
	}
	
	public void setTypes(List<Type> types) {
		this.types = types;
	}
	
	@PostConstruct
	public void init() {
		setTypes(services.getAllTypes());
	}
}
