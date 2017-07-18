package com.rapps.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapps.dao.EmployeeDao;
import com.rapps.model.Employee;
import com.rapps.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {

//	private EmployeeDao employeeDaoImpl = new EmployeeDaoImpl();

	@Autowired
	private EmployeeDao employeeDaoImpl;
	@Override
	public List<Employee> getAllEmployees() {
		return employeeDaoImpl.getAllEmployees();
	}
	@Override
	public Employee getEmployee(long employeeId) {
		return employeeDaoImpl.getEmployee(employeeId);
	}
	@Override
	public Employee createEmployee(Employee employee) {
		return employeeDaoImpl.createEmployee(employee);
	}
	@Override
	public Employee updateEmployee(long employeeId,Employee employee) {
		return employeeDaoImpl.updateEmployee(employeeId,employee);
	}
	@Override
	public void deleteEmployee(long employeeId) {
		 employeeDaoImpl.deleteEmployee(employeeId);
	}
}
