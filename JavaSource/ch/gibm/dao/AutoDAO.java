package ch.gibm.dao;

import ch.gibm.entity.Auto;

public class AutoDAO extends GenericDAO<Auto>{
	
	private static final long serialVersionUID = 1L;

	public AutoDAO() {
		super(Auto.class);
	}

	public void delete(Auto entity) {
        	super.delete(entity.getId(), Auto.class);
	}
}
