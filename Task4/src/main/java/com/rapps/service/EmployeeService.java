package com.rapps.service;

import java.util.List;

import com.rapps.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	public Employee getEmployee(long employeeId);
	public Employee createEmployee(Employee employee);
	public Employee updateEmployee(long employeeId,Employee employee);
	public void deleteEmployee(long employeeId);

}
