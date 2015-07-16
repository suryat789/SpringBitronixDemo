package com.technoficent.test;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.technoficent.btm.entities.Employee;
import com.technoficent.btm.services.EmployeeSEI;
import com.technoficent.btm.to.Status;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class EmployeeTest {
	
	@Autowired
	private EmployeeSEI empService;
	
	private static final String EMP_ID = "9001";
	
	public EmployeeSEI getEmpService() {
		return empService;
	}

	@Test
	public void test1addEmployee() throws Exception {
		Employee Employee = new Employee();
		Employee.setEmployeeID(EMP_ID);
		Employee.setEmployeeDept("90");
		Employee.setEmployeeName("Test User");
		Status status = getEmpService().addEmployee(Employee);
		Assert.assertNotNull("Status is Null", status);
	}
	
	@Test
	public void test2getEmpoyeeDetails() throws Exception {
		Employee employee = getEmpService().getEmpoyeeDetails(EMP_ID);
		Assert.assertNotNull("employee is Null", employee);
	}
	
	
	@Test
	public void test3updateEmployee() throws Exception {
		Employee Employee = new Employee();
		Employee.setEmployeeID(EMP_ID);
		Employee.setEmployeeDept("91");
		Employee.setEmployeeName("Test User1");
		
		Status status = getEmpService().updateEmployee(Employee);
		Assert.assertNotNull("Status is Null", status);
	}
	
	@Test
	public void test4deleteEmployeeByEmpID() throws Exception {
		
		Status status = getEmpService().deleteEmployeeByEmpID(EMP_ID);
		Assert.assertNotNull("Status is Null", status);
	}
}
