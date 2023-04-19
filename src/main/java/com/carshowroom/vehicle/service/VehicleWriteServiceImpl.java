package com.carshowroom.vehicle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carshowroom.vehicle.model.Vehicle;
import com.carshowroom.vehicle.repository.VehicleRepository;

@Service
public class VehicleWriteServiceImpl implements VehicleWriteService {

	private VehicleRepository vehicleRepository;

	@Autowired
	public VehicleWriteServiceImpl(VehicleRepository vehicleRepository) {
		super();
		this.vehicleRepository = vehicleRepository;
	}

	@Override
	public Vehicle addVehicle(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	@Override
	public Vehicle updateVehicle(Vehicle vehicle, int id) {
		Vehicle v1 = vehicleRepository.findById(id).get();

		if (v1 != null) {
			v1.setBrand(vehicle.getBrand());
			v1.setCc(vehicle.getCc());
			v1.setPrice(vehicle.getPrice());
			v1.setVehicleName(vehicle.getVehicleName());
		}
		vehicleRepository.save(v1);
		return v1;
	}

	@Override
	public boolean deleteVehicle(int id) {
		Vehicle vehicle = vehicleRepository.findById(id).get();
		if(vehicle!=null) {
			vehicleRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
}
