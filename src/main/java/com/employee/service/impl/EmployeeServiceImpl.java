package com.employee.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.services.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	@Transactional
	public Object saveEmployee(Employee employee) {
		Map<String, Object> map=new HashMap<String, Object>();
		if(employee.getEmployeeName().isEmpty())
		{
			map.put("status","Error");
			map.put("Msg","please enter the Employee Name" );
		}
		else if(employee.getDepartment().isEmpty())
		{
			map.put("status","Error");
			map.put("Msg", "please enter the department");
		}
		else
		{
			employeeRepository.save(employee);
			map.put("status","200");
			map.put("Msg","Data inserted Successfully");
		}
		
		return map;
	}
	@Override
	@Transactional
	public List<Employee> getAllEmployees()
	{
		return employeeRepository.findAll();
	}
	@Override
	@Transactional
	public Employee getEmployeeInfoById(int id) {
	
		return employeeRepository.findById(id).orElse(null);
	}
	@Override
	@Transactional
	public Object deleteEmployeeInfo(int id) {
	Map<String, Object> map=new HashMap<String, Object>();
	employeeRepository.deleteById(id);
	map.put("Status", "200");
	map.put("Msg", "Data Deleted SuccessFully");
	return map;
	}

	@Override
	public Object updateEmployeeInfo(Employee employee) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<String, Object>();
		if(employee.getEmployeeName().isEmpty())
		{
			map.put("Status", "Error");
			map.put("Msg", "please Enter the Employee Name");
		}
		else if(employee.getDepartment().isEmpty())
		{
			map.put("status","Error");
			map.put("Msg","Please enter the department name");
		}
		else {
			employeeRepository.saveAndFlush(employee);
			map.put("status","200");
			map.put("Msg","Data updated successfully");
		}
		return map;
	}

}
