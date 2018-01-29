package com.lk.cc.bcon.finance.web.resource.finder;

import java.util.List;

import com.lk.cc.bcon.finance.resource.EmployeeResource;

public interface EmployeeResourceFinder extends ResourceFinder<EmployeeResource, String> {
	
	EmployeeResource findById(String id);
	
	List<EmployeeResource> findAllEmployees();

}
