package com.lk.cc.bcon.finance.mapper;


import com.lk.cc.bcon.finance.entity.EmployeeEntity;
import com.lk.cc.bcon.finance.resource.EmployeeResource;

import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;

//This mapper class maps the entity to resource and vice versa. 
@Mapper(withIoC = IoC.SPRING)
public interface EmployeeMapper {
	

	/**
	 * As resource.
	 *
	 * @param entity the entity
	 * @return the employee resource
	 */
	@Maps(withIgnoreMissing = IgnoreMissing.DESTINATION)
	EmployeeResource asResource(EmployeeEntity entity);
	

	/**
	 * As entity.
	 *
	 * @param resource the resource
	 * @return the employee entity
	 */
	@Maps(withIgnoreMissing = IgnoreMissing.SOURCE)
	EmployeeEntity asEntity(EmployeeResource resource);
	

	/**
	 * Update resource.
	 *
	 * @param entity the entity
	 * @param resource the resource
	 * @return the employee resource
	 */
	@Maps(withIgnoreMissing = IgnoreMissing.DESTINATION)
	EmployeeResource updateResource(EmployeeEntity entity, EmployeeResource resource);
	

	/**
	 * Update entity.
	 *
	 * @param resource the resource
	 * @param entity the entity
	 * @return the employee entity
	 */
	@Maps(withIgnoreMissing = IgnoreMissing.SOURCE)
	EmployeeEntity updateEntity(EmployeeResource resource, EmployeeEntity entity);
}
