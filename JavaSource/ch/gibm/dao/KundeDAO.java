package ch.gibm.dao;

import ch.gibm.entity.Kunde;

public class KundeDAO extends GenericDAO<Kunde>{
	
	private static final long serialVersionUID = 1L;

	public KundeDAO() {
		super(Kunde.class);
	}

	public void delete(Kunde entity) {
        	super.delete(entity.getId(), Kunde.class);
	}
}
