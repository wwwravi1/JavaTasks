package com.rapps.daoimpl;

import java.util.ArrayList;
import java.util.List;

import com.rapps.dao.EmployeeDao;
import com.rapps.model.Employee;
import com.rapps.util.EmployeeData;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public Employee createEmployee(Employee employee) {

		return EmployeeData.createEmployee(employee);
	}

	@Override
	public Employee updateEmployee(long employeeId,Employee employee) {
		
		return EmployeeData.updateEmployee(employeeId, employee);
	}

	@Override
	public Employee getEmployee(long employeeId) {

		return EmployeeData.getEmployee(employeeId);
	}

	@Override
	public List<Employee> getAllEmployees() {

		return new ArrayList<Employee>(EmployeeData.getAllEmployees());
	}

	@Override
	public void deleteEmployee(long employeeId) {

		EmployeeData.deleteEmployee(employeeId);
	}

}
