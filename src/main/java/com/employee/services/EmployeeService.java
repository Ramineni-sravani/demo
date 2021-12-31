package com.employee.services;

import java.util.List;

import com.employee.model.Employee;

public interface EmployeeService {
	public Object saveEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeInfoById(int id);
	public Object deleteEmployeeInfo(int id);
	public Object updateEmployeeInfo(Employee employee);
	

}
