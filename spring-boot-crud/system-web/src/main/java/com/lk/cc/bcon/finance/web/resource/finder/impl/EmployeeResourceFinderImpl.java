package com.lk.cc.bcon.finance.web.resource.finder.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.lk.cc.bcon.finance.entity.EmployeeEntity;
import com.lk.cc.bcon.finance.mapper.EmployeeMapper;
import com.lk.cc.bcon.finance.repo.EmployeeRepository;
import com.lk.cc.bcon.finance.resource.EmployeeResource;
import com.lk.cc.bcon.finance.web.resource.finder.AbstractResourceFinder;
import com.lk.cc.bcon.finance.web.resource.finder.EmployeeResourceFinder;

@Named("employeeResourceFinder")
public class EmployeeResourceFinderImpl extends AbstractResourceFinder<EmployeeResource, EmployeeEntity, EmployeeRepository, String> implements EmployeeResourceFinder {
	/** The mapper. */
	private EmployeeMapper mapper;
	
	@Inject
	public EmployeeResourceFinderImpl(EmployeeRepository repo, EmployeeMapper mapper) {
		super(repo);
		this.mapper = mapper;
	}

	@Override
	protected EmployeeResource toResource(EmployeeEntity entity) {
		
		return mapper.asResource(entity);
	}

	//@Override
	public EmployeeResource findById(String id) {

		EmployeeEntity entity = repo.findOne(id);
		return mapper.asResource(entity);
		
	}

	//@Override
	public List<EmployeeResource> findAllEmployees() {
		List<EmployeeEntity> list = repo.findAll();
		return toResources(list);

	}

	public EmployeeResource findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
