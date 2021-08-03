package com.employeeManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeManagementSystem.Domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
