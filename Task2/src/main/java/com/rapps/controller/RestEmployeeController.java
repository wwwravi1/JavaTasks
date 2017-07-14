package com.rapps.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import com.rapps.model.Employee;
import com.rapps.service.EmployeeService;

@Path("employees")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
@Consumes(MediaType.APPLICATION_JSON)
public class RestEmployeeController {

	private EmployeeService employeeService = new EmployeeService();

	@GET
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GET
	@Path("/{employeeId}")
	public Employee getEmployee(@PathParam(value = "employeeId") long employeeId) {
		return employeeService.getEmployee(employeeId);
	}

	@POST
	public Employee createEmployee(Employee employee) {
		return employeeService.createEmployee(employee);
	}

	@PUT
	@Path("/{employeeId}")
	public Employee updateEmployee(@PathParam(value = "employeeId") long employeeId,Employee employee) {
		return employeeService.updateEmployee(employeeId,employee);
	}

	@DELETE
	@Path("/{employeeId}")
	public void deleteEmployee(@PathParam(value = "employeeId") long employeeId) {
		 employeeService.deleteEmployee(employeeId);
	}
}
