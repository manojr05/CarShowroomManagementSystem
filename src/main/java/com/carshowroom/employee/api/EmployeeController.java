package com.carshowroom.employee.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.carshowroom.employee.model.Employee;
import com.carshowroom.employee.service.EmployeeReadService;
import com.carshowroom.employee.service.EmployeeWriteService;

import lombok.Data;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	private EmployeeWriteService employeeWriteService;
	private EmployeeReadService employeeReadService;

	@Autowired
	public EmployeeController(EmployeeWriteService employeeWriteService, EmployeeReadService employeeReadService) {
		super();
		this.employeeWriteService = employeeWriteService;
		this.employeeReadService = employeeReadService;
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id) {
		return new ResponseEntity<Employee>(employeeReadService.getEmployeeById(id), HttpStatus.OK);
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return employeeReadService.getAllEmployee();
	}

	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> putEmployee(@RequestBody Employee employee, @PathVariable int id) {
		return new ResponseEntity<Employee>(employeeWriteService.updateEmployee(employee, id), HttpStatus.OK);
	}

	@PostMapping("/employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeWriteService.addEmployee(employee), HttpStatus.CREATED);
	}

	@DeleteMapping("/employee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
		boolean deleteEmployee = employeeWriteService.deleteEmployee(id);
		
		if (deleteEmployee)
			return new ResponseEntity<String>("deleted successfully", HttpStatus.OK);
		else
			return new ResponseEntity<String>("resource not found", HttpStatus.NOT_FOUND);
	}

}
