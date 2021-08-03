package com.employeeManagementSystem.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employeeManagementSystem.Domain.Employee;
@Service
public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	void save(Employee employee);
	Employee getEmployeeById(long id);
	void deleteEmployeeById(long id);
}
