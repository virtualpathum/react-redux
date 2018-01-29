package com.lk.cc.bcon.finance.service;

import com.lk.cc.bcon.finance.resource.EmployeeResource;

public interface EmployeeService {
	
	/**
	 * Save or update.
	 *
	 * @param resource the resource
	 * @return the employee resource
	 */
	EmployeeResource saveOrUpdate (EmployeeResource resource);
	
	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	void delete(String id);
}