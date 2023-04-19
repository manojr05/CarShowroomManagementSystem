package com.carshowroom.vehicle.service;

import java.util.List;
import com.carshowroom.vehicle.model.Vehicle;

public interface VehicleReadService {
	List<Vehicle> getAllVehicle();
	Vehicle getVehicleById(int id);
}
