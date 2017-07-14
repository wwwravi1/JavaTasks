package com.rapps.service;

import java.util.List;

import com.rapps.dao.EmployeeDao;
import com.rapps.daoimpl.EmployeeDaoImpl;
import com.rapps.model.Employee;

public class EmployeeService {

	private EmployeeDao employeeDaoImpl = new EmployeeDaoImpl();

	public List<Employee> getAllEmployees() {
		return employeeDaoImpl.getAllEmployees();
	}
	
	public Employee getEmployee(long employeeId) {
		return employeeDaoImpl.getEmployee(employeeId);
	}
	public Employee createEmployee(Employee employee) {
		return employeeDaoImpl.createEmployee(employee);
	}
	public Employee updateEmployee(long employeeId,Employee employee) {
		return employeeDaoImpl.updateEmployee(employeeId,employee);
	}
	public void deleteEmployee(long employeeId) {
		 employeeDaoImpl.deleteEmployee(employeeId);
	}
}
