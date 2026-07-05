package com.employee.emp_man_backend.service;

import org.springframework.stereotype.Service;

import com.employee.emp_man_backend.entity.Employee;
import com.employee.emp_man_backend.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
   
	private final EmployeeRepository employeeRepository;
	
	public  EmployeeServiceImpl(EmployeeRepository employeeRepository)
	{
		this.employeeRepository = employeeRepository;
	}
	@Override
	public Employee addEmployee(Employee employee)
	{
		 if(employeeRepository.existsByEmployeeId(employee.getEmployeeId()))
		 {
			 throw new RuntimeException("employee already exists");
		 }
		  return employeeRepository.save(employee);
		  
	}
	
	@Override
	public Employee updateEmployee(String employeeId,Employee employee)
	{
		Employee emp = employeeRepository.findById(employeeId).orElseThrow(()-> new RuntimeException("Employee Not Found"));
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setEmail(employee.getEmail());
		emp.setMobile(employee.getMobile());
		emp.setDepartment(employee.getDepartment());
		emp.setDesignation(employee.getDesignation());
		emp.setStatus(employee.getStatus());
		
		return employeeRepository.save(emp);
		
	}
	
	@Override
	public String deleteEmployee(String employeeId)
	{
		if(!employeeRepository.existsById(employeeId))
		{
			return "Employee not found";
		}
		employeeRepository.deleteById(employeeId);
		
		return "Employee deleted successfully";
	}
	
}
