package com.technoficent.btm.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.technoficent.btm.entities.Employee;
import com.technoficent.btm.to.Status;
import com.technoficent.btm.to.StatusConstants;

@SuppressWarnings(value = "unchecked")
@Repository("employeeDao")
public class EmployeeDAOImpl extends AbstractDAO implements EmployeeDAO {

	@Override
	public Employee getEmpoyeeDetails(String id) {
		Query query = getEntityManager().createQuery(" from Employee emp WHERE emp.employeeID = :employeeID");
		query.setParameter("employeeID", id);
		
		List<Employee> employees = query.getResultList();
		if(employees != null && !employees.isEmpty()){
			return employees.get(0);
		}
		return null;
	}
	
	public Status updateEmployee(Employee employee){
		Status status = null;
		try {
			getEntityManager().merge(employee);
			status = new Status(StatusConstants.StatusCode.SUCCESS, StatusConstants.StatusMessages.SUCCESS);
		} catch (Exception e) {
			status = new Status(StatusConstants.StatusCode.FAILURE, StatusConstants.StatusMessages.FAILURE);
			e.printStackTrace();
		}
		return status;
	}
	
	public Status deleteEmployeeByEmpID(String empID) {
		Status status = null;
		try {
			Employee employee = getEmpoyeeDetails(empID);
			delete(employee);
			status = new Status(StatusConstants.StatusCode.SUCCESS, StatusConstants.StatusMessages.SUCCESS);
		} catch (Exception ex){
			status = new Status(StatusConstants.StatusCode.FAILURE, StatusConstants.StatusMessages.FAILURE);
			ex.printStackTrace();
		}
		return status;
	}

	@Override
	public Status addEmployee(Employee employee) {
		Status status = null;
		try {
			persist(employee);
			status = new Status(StatusConstants.StatusCode.SUCCESS, StatusConstants.StatusMessages.SUCCESS);
		} catch (Exception ex){
			status = new Status(StatusConstants.StatusCode.FAILURE, StatusConstants.StatusMessages.FAILURE);
			ex.printStackTrace();
		}
		return status;
	}
}
