package com.carshowroom.vehicle.service;

import com.carshowroom.vehicle.model.Vehicle;

public interface VehicleWriteService {
	Vehicle addVehicle(Vehicle vehicle);
	Vehicle updateVehicle(Vehicle vehicle, int id);
	boolean deleteVehicle(int id);
}
