package com.carshowroom.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carshowroom.employee.model.Employee;
import com.carshowroom.employee.repository.EmployeeRepository;

@Service
public class EmployeeWriteServiceImpl implements EmployeeWriteService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeWriteServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee, int id) {
		Employee e2 = employeeRepository.findById(id).get();

		if (e2 != null) {
			e2.setAge(employee.getAge());
			e2.setDlNumber(employee.getDlNumber());
			e2.setDob(employee.getDob());
			e2.setEmployeeName(employee.getEmployeeName());
			e2.setIsAdmin(employee.getIsAdmin());
			e2.setJobRole(employee.getJobRole());
			e2.setSalary(employee.getSalary());
		}

		return employeeRepository.save(e2);
	}

	@Override
	public boolean deleteEmployee(int id) {
		Employee e2 = employeeRepository.findById(id).get();
		if(e2!=null) {
			employeeRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
}
