package com.lk.cc.bcon.finance.resource;

import java.io.Serializable;

public abstract class AbstractResource<T extends Serializable> implements Resource<T> {
	
	/** The resource id. */
	protected T id;
	
	/**
	 * Instantiates a new abstract resource.
	 *
	 * @param resourceId the resource id
	 */
	public AbstractResource(T id){
		this.id = id;
	}

	
	/* (non-Javadoc)
	 * @see com.lk.student.manager.resource.Resource#getId()
	 */
	public T getId() {
		return id;
	}

	
	/* (non-Javadoc)
	 * @see com.lk.student.manager.resource.Resource#setId(java.lang.Object)
	 */
	public void setId(T id) {
		this.id = id;
	}
}
