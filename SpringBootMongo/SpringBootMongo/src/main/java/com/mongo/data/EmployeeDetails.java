package com.mongo.data;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.model.Employee;

public interface EmployeeDetails extends MongoRepository<Employee, String>{

Optional<Employee> findById(String id);



}
