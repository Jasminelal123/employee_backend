package com.employee.emp_man_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.emp_man_backend.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String>{
   
}
