package com.rapps.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.rapps.dao.EmployeeDao;
import com.rapps.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private JdbcTemplate jdbcTemplate;

	@Override
	public Employee createEmployee(Employee employee) {

		String employeeCountQuery = "SELECT MAX(Employee_Id) AS highistNumber From Employee";
		int employeeCount = jdbcTemplate.queryForObject(employeeCountQuery, Integer.class);
		String createEmployeeQuery = "Insert into Employee(employee_Id,firstName,lastName,salary) values (?,?,?,?)";
		getJdbcTemplate().update(createEmployeeQuery, new Object[] { ++employeeCount, employee.getFirstName(),
				employee.getLastName(), employee.getSalary() });
		String getEmployeeQuery = "Select * from Employee where  employee_Id = ?";
		return jdbcTemplate.queryForObject(getEmployeeQuery, new Object[] { employeeCount }, new EmployeeMapper());
	}

	@Override
	public Employee updateEmployee(long employeeId, Employee employee) {

		String query = "UPDATE Employee SET firstName = ?, lastName= ?, salary = ? WHERE Employee_ID = ?";
		jdbcTemplate.update(query,
				new Object[] { employee.getFirstName(), employee.getLastName(), employee.getSalary(), employeeId });
		String getEmployeeQuery = "Select * from Employee where  employee_Id = ?";
		return jdbcTemplate.queryForObject(getEmployeeQuery, new Object[] { employeeId }, new EmployeeMapper());
	}

	@Override
	public Employee getEmployee(long employeeId) {

		Employee employee = null;
		String query = "Select * from Employee where employee_Id = ?";
		try {
			employee = jdbcTemplate.queryForObject(query, new Object[] { employeeId }, new EmployeeMapper());
		} catch (Exception e) {

			employee = null;
			return employee;
		}
		if (employee == null)
			return new Employee();
		else
			return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {

		String query = "Select * from Employee";
		return jdbcTemplate.query(query, new EmployeeMapper());
	}

	@Override
	public void deleteEmployee(long employeeId) {

		String query = "DELETE FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
		jdbcTemplate.update(query, new Object[] { employeeId });
	}

	private static final class EmployeeMapper implements RowMapper<Employee> {

		@Override
		public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {

			Employee employee = new Employee();
			employee.setId(resultSet.getLong("employee_Id"));
			employee.setFirstName(resultSet.getString("firstName"));
			employee.setLastName(resultSet.getString("lastName"));
			employee.setSalary(resultSet.getDouble("salary"));
			return employee;
		}

	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
