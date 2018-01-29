package com.lk.cc.bcon.finance.web.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lk.cc.bcon.finance.resource.EmployeeResource;
import com.lk.cc.bcon.finance.service.EmployeeService;
import com.lk.cc.bcon.finance.web.resource.finder.EmployeeResourceFinder;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	/** The Constant logger. */
	public static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	/** The resource finder. */
	private EmployeeResourceFinder resourceFinder;

	/** The service. */
	private EmployeeService service;


	@Inject
	public EmployeeController(EmployeeResourceFinder resourceFinder, EmployeeService service) {
		this.resourceFinder = resourceFinder;
		this.service = service;
	}

	@RequestMapping(value = "/employee/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<EmployeeResource> listAllEmployees() {
		return resourceFinder.findAll();
	}


	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public EmployeeResource getEmployee(@PathVariable("id") String id) {
		logger.info("Fetching employee with id {}", id);
		return resourceFinder.findOne(id);

	}

	@RequestMapping(value = "/employee/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public EmployeeResource create(@RequestBody EmployeeResource resource) {
		logger.info("Creating employee : {}", resource);
		return service.saveOrUpdate(resource);

	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public EmployeeResource update(@PathVariable("id") String id, @RequestBody EmployeeResource resource) {
		logger.info("Updating employee with id {}", id);
		return service.saveOrUpdate(resource);
	}


	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") String id) {
		logger.info("Fetching & Deleting employee with id {}", id);
		service.delete(id);
	}
	
	@RequestMapping(value = "/employee/get/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Page<EmployeeResource> getAllEmployees(Pageable pageable) {
		return resourceFinder.findAll(pageable);
	}


}