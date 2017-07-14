package com.rapps.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.rapps.model.Employee;

public class EmployeeData {

	private static Map<Long, Employee> employees = new HashMap();

	static {
		createDummyEmployees();
	}

	public static Collection<Employee> getAllEmployees() {
		Collection<Employee> emp = employees.values();
		return emp;
	}

	public static Employee getEmployee(long employeeId) {
		if (employees.containsKey(employeeId)) {
			return employees.get(employeeId);
		} else {
			return new Employee();
		}
	}

	public static Employee createEmployee(Employee employee) {

		long eid = employees.values().size();
		employee.setId(++eid);
		employees.put(eid, employee);
		return employee;
	}

	public static Employee updateEmployee(long employeeId, Employee employee) {
		if (employees.containsKey(employeeId)) {
			employee.setId(employeeId);
			employees.put(employeeId, employee);
			return employee;
		} else {
			return new Employee();
		}
	}

	public static void deleteEmployee(long employeeId) {
		employees.remove(employeeId);
	}

	private static void createDummyEmployees() {
		Employee employee1 = new Employee(1, "Sundar", "Pichai", 50000.0);
		Employee employee2 = new Employee(2, "Satya", "Nadella", 60000.0);
		Employee employee3 = new Employee(3, "Tim", "cook", 80000.0);

		employees.put(employee1.getId(), employee1);
		employees.put(employee2.getId(), employee2);
		employees.put(employee3.getId(), employee3);
	}

}
