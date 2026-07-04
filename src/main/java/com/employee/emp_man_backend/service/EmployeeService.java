package com.employee.emp_man_backend.service;

import com.employee.emp_man_backend.entity.Employee;

public interface EmployeeService {
  
	 Employee addEmployee(Employee employee);
	 Employee updateEmployee(String employeeId,Employee employee);
	 String deleteEmployee(String empoyeeId);
	
}
