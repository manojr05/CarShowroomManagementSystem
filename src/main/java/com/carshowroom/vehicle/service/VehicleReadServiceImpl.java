package com.carshowroom.vehicle.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carshowroom.employee.model.Employee;
import com.carshowroom.employee.repository.EmployeeRepository;
import com.carshowroom.exception.ResourceNotFoundException;
import com.carshowroom.vehicle.model.Vehicle;
import com.carshowroom.vehicle.repository.VehicleRepository;

@Service
public class VehicleReadServiceImpl implements VehicleReadService {

	private VehicleRepository vehicleRepository;

	@Autowired
	public VehicleReadServiceImpl(VehicleRepository vehicleRepository) {
		super();
		this.vehicleRepository = vehicleRepository;
	}

	@Override
	public List<Vehicle> getAllVehicle() {
		return vehicleRepository.findAll();
	}

	@Override
	public Vehicle getVehicleById(int id) {
		Optional<Vehicle> findById = vehicleRepository.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}else {
			throw new ResourceNotFoundException("Vehicle", "id", id);
		}
	}

}
