package com.technoficent.btm.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.technoficent.btm.dao.EmployeeDAO;
import com.technoficent.btm.entities.Employee;
import com.technoficent.btm.to.Status;

public class EmployeeImpl implements EmployeeSEI {

	@Autowired
	private EmployeeDAO empDAO;
	
	public EmployeeDAO getEmpDAO() {
		return empDAO;
	}
	
	@Override
	@Transactional
	public Status addEmployee(Employee employee) {
		return getEmpDAO().addEmployee(employee);
	}

	@Override
	@Transactional
	public Employee getEmpoyeeDetails(String id) {
		return getEmpDAO().getEmpoyeeDetails(id);
	}

	@Override
	@Transactional
	public Status updateEmployee(Employee employee) {
		return getEmpDAO().updateEmployee(employee);
	}

	@Override
	@Transactional
	public Status deleteEmployeeByEmpID(String empID) {
		return getEmpDAO().deleteEmployeeByEmpID(empID);
	}

}
