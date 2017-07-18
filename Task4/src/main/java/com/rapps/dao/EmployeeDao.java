package com.rapps.dao;

import java.util.List;

import com.rapps.model.Employee;

public interface EmployeeDao {

	public Employee createEmployee(Employee employee);
	public Employee getEmployee(long employeeId);
	public List<Employee> getAllEmployees();
	public void deleteEmployee(long employeeId);
	public Employee updateEmployee(long employeeId,Employee employee);
}
