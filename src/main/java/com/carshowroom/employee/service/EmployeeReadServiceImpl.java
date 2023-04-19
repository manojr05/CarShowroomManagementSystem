package com.carshowroom.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carshowroom.employee.model.Employee;
import com.carshowroom.employee.repository.EmployeeRepository;
import com.carshowroom.exception.ResourceNotFoundException;

@Service
public class EmployeeReadServiceImpl implements EmployeeReadService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeReadServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee> findById = employeeRepository.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}else {
			throw new ResourceNotFoundException("Employee", "id", id);
		}
	}

}
