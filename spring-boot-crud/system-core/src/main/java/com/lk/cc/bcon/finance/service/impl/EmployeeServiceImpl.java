package com.lk.cc.bcon.finance.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.lk.cc.bcon.finance.entity.EmployeeEntity;
import com.lk.cc.bcon.finance.mapper.EmployeeMapper;
import com.lk.cc.bcon.finance.repo.EmployeeRepository;
import com.lk.cc.bcon.finance.resource.EmployeeResource;
import com.lk.cc.bcon.finance.service.EmployeeService;


@Named("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	/** The repo. */
	@Inject
	private EmployeeRepository repo;

	/** The mapper. */
	@Inject
	private EmployeeMapper mapper;


	//@Override
	@Transactional(rollbackFor = Exception.class)
	public EmployeeResource saveOrUpdate(EmployeeResource resource) {
		if (null == resource.getId()) {
			return create(resource);
		} else {
			return update(resource);
		}
	}

	//@Override
	public void delete(String id) {
		repo.delete(id);
	}

	private EmployeeResource create(EmployeeResource resource) {
		EmployeeEntity entity = mapper.asEntity(resource);

		return mapper.asResource(repo.save(entity));
	}

	private EmployeeResource update(EmployeeResource resource) {
		EmployeeEntity entity = repo.findOne(resource.getId());
		// TODO: perform optimistic locking check
		entity = mapper.updateEntity(resource, entity);

		entity = repo.save(entity);
		return mapper.updateResource(entity, resource);
	}

}
