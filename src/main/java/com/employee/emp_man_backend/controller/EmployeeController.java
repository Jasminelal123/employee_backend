package com.employee.emp_man_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.employee.emp_man_backend.entity.Employee;
import com.employee.emp_man_backend.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins="http://localhost:3000")
public class EmployeeController {
    private final EmployeeService employeeService;
    
    public EmployeeController(EmployeeService employeeService)
    {
    	this.employeeService = employeeService;
    }
    
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
    {
    	Employee savedEmployee = employeeService.addEmployee(employee);
    	return ResponseEntity.ok(savedEmployee);
    	
    }
    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable String employeeId,@RequestBody Employee employee)
    {
    	Employee updatedEmployee = employeeService.updateEmployee(employeeId,employee);
    			return ResponseEntity.ok(updatedEmployee);
    }
    
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String employeeId)
    {
    	String message = employeeService.deleteEmployee(employeeId);
    	return ResponseEntity.ok(message);
    }
    
}
