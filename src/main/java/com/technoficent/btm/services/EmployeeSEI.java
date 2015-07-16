package com.technoficent.btm.services;
import com.technoficent.btm.entities.Employee;
import com.technoficent.btm.to.Status;


public interface EmployeeSEI {
	
	public Status addEmployee(Employee employee);
	
	public Employee getEmpoyeeDetails(String id);
	
	public Status updateEmployee(Employee employee);
	
	public Status deleteEmployeeByEmpID(String empID);
		
}