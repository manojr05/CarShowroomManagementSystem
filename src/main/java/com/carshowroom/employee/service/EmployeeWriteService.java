package com.carshowroom.employee.service;

import com.carshowroom.employee.model.Employee;

public interface EmployeeWriteService {
	Employee addEmployee(Employee employee);
	Employee updateEmployee(Employee employee, int id);
	boolean deleteEmployee(int id);
}
