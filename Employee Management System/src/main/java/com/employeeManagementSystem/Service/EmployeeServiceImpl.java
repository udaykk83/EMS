package com.employeeManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeManagementSystem.Domain.Employee;
import com.employeeManagementSystem.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepo;
	
	
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepo.findAll();
	}


	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		this.employeeRepo.save(employee);
		
	}


	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
		
		Optional<Employee> optional=employeeRepo.findById(id);
		Employee employee=null;
		if(optional.isPresent()) {
			employee=optional.get();
		}
		else {
			throw new RuntimeException("Employee not found for id "+id);
		}
		return employee;
	}


	@Override
	public void deleteEmployeeById(long id) {
		// TODO Auto-generated method stub
		this.employeeRepo.deleteById(id);		
	}

	
}
