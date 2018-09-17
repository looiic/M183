package ch.gibm.dao;

import ch.gibm.entity.GeneralEntity;

public class EntityDAO extends GenericDAO<GeneralEntity> {

	private static final long serialVersionUID = 1L;

	public EntityDAO() {
		super(GeneralEntity.class);
	}

	public void delete(GeneralEntity entity) {
        	super.delete(entity.getId(), GeneralEntity.class);
	}
}
