package com.mongo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.data.EmployeeDetails;
import com.mongo.model.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	EmployeeDetails erepo;
	
	@Autowired
	public EmployeeController(EmployeeDetails erepo) {
		this.erepo=erepo;
	}
	
	@PostMapping("/employee")
	public String addEmployee(@RequestBody Employee emp) {
		erepo.save(emp);
		return "Employee has been added to the db";
	}
	
	@GetMapping("/employee")
	public List<Employee> getEmployees(){
		return erepo.findAll();
	}
	
	
	@GetMapping("/employee/{empId}")
	public Optional<Employee> getEmployee(@PathVariable("empId") String id){
		return erepo.findById(id);
	}

	@PutMapping("/employee/{empId}")
	public String updateEmployee(@PathVariable("empId") String id, @RequestBody Employee emp) {
		
		erepo.findAll().stream()	
						.filter(obj -> obj.getEmpId().equals(String.valueOf(id)))
						.forEach(ob -> {
							ob.setAge(emp.getAge());
							erepo.save(ob);
						});
						
		return "Employee details updated";
		
	}

	@DeleteMapping("/employee/{empId}")
	public String deleteEmployee(@PathVariable("empId") String id) {
		erepo.deleteById(id);
		return "Employee deleted";
	}
	
	@DeleteMapping("/employees")
	public String deleteEmployees() {
		erepo.deleteAll();
		return "Employees deleted";
	}
	
	
}
