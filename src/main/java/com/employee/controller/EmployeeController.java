package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.services.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/employee/saveEmployee",method = RequestMethod.POST)
	public Object saveEmployee(@RequestBody Employee employee)
	{
		return(employeeService.saveEmployee(employee));
	}
	@RequestMapping(value = "/employee/getEmployee",method=RequestMethod.GET)
	public List<Employee> getAllEmployee()
	{
		return (employeeService.getAllEmployees());
	}
	@RequestMapping(value = "/employee/getEmployeeById/{id}",method = RequestMethod.GET)
	public Employee getAllEmployeeById(@PathVariable int id)
	{
		return(employeeService.getEmployeeInfoById(id));
	}
	@RequestMapping(value = "/employee/deleteEmployee/{id}",method = RequestMethod.DELETE)
	public Object deleteEmployeeData(@PathVariable int id)
	{
	return(employeeService.deleteEmployeeInfo(id));
	}
	@RequestMapping(value = "/employee/updateEmployee",method = RequestMethod.PUT)
	public Object updateEmployeeData(@RequestBody Employee employee)
	{
	return(employeeService.updateEmployeeInfo(employee));
	}


}
