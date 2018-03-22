package com.jpa.data;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.model.Employee;

public interface EmployeeDetails extends JpaRepository<Employee, Integer>{

}
