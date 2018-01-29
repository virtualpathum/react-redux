package com.lk.cc.bcon.finance.web.controller.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import com.lk.cc.bcon.finance.resource.EmployeeResource;
import com.lk.cc.bcon.finance.web.controller.EmployeeController;


@Ignore
public class EmployeeControllerTest extends AbstractControllerTest {
	
	Logger LOG = Logger.getLogger(EmployeeControllerTest.class);
	
	@Inject
	EmployeeController controller;
	
	
	@Test
	public void testCreateEmployeeMethod() {
		
		//Creating the employee
		EmployeeResource resource = new EmployeeResource();
		resource.setFirstName("Test Employee");
		
		resource.setAge(17);

		
		EmployeeResource created = controller.create(resource);
		assertNotNull(created);
		LOG.info("created : " + created);

	}
	

	@Test
	public void testListAllEmployeesMethod() {
		
		List<EmployeeResource> list = controller.listAllEmployees();
		assertNotNull(list);
		assertEquals(1, list.size());
		LOG.info("employee list : " + list.size());

	}
	

	@Test
	public void testGetEmployeeMethod() {
		
		EmployeeResource employee = controller.getEmployee("");
		assertNotNull(employee);

	}
	

	@Test
	public void testUpdateEmployeeMethod() {
		
		EmployeeResource employee = controller.getEmployee("");
		employee.setFirstName("Name Updated");
		
		EmployeeResource updatedEmployee = controller.update("", employee);
		assertNotNull(updatedEmployee);
		assertEquals("Name Updated", updatedEmployee.getFirstName());

	}
	

	//@Test
	public void testDeleteStudentMethod() {
		
		EmployeeResource beforeDelete = controller.getEmployee("");
		assertNotNull(beforeDelete);
		
		//controller.deleteStudent(1);
		
		EmployeeResource aftterDelete = controller.getEmployee("");
		assertNull(aftterDelete);


	}


}
