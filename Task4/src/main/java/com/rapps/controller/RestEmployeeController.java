package com.rapps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rapps.model.Employee;
import com.rapps.serviceimpl.EmployeeServiceImpl;

@RequestMapping("employees")
@RestController
public class RestEmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable("employeeId") long employeeId) {
		return employeeService.getEmployee(employeeId);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.PUT)
	public Employee updateEmployee(@PathVariable("employeeId") long employeeId, @RequestBody Employee employee) {
		return employeeService.updateEmployee(employeeId, employee);
	}

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable("employeeId") long employeeId) {
		employeeService.deleteEmployee(employeeId);
	}
}
