package com.carshowroom.employee.service;

import java.util.List;

import com.carshowroom.employee.model.Employee;

public interface EmployeeReadService {
	List<Employee> getAllEmployee();
	Employee getEmployeeById(int id);
}
