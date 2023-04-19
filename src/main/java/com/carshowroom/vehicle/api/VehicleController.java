package com.carshowroom.vehicle.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.carshowroom.vehicle.model.Vehicle;
import com.carshowroom.vehicle.service.VehicleReadService;
import com.carshowroom.vehicle.service.VehicleWriteService;

@RestController
public class VehicleController {

	private VehicleWriteService vehicleWriteService;
	private VehicleReadService vehicleReadService;

	@Autowired
	public VehicleController(VehicleWriteService vehicleWriteService, VehicleReadService vehicleReadService) {
		super();
		this.vehicleWriteService = vehicleWriteService;
		this.vehicleReadService = vehicleReadService;
	}

	@GetMapping("/vehicle/{id}")
	public ResponseEntity<Vehicle> getVehicle(@PathVariable int id) {
		return new ResponseEntity<Vehicle>(vehicleReadService.getVehicleById(id), HttpStatus.OK);
	}

	@GetMapping("/vehicles")
	public List<Vehicle> getAllVehicle() {
		return vehicleReadService.getAllVehicle();
	}

	@PutMapping("/vehicle/{id}")
	public ResponseEntity<Vehicle> putVehicle(@RequestBody Vehicle vehicle, @PathVariable int id) {
		return new ResponseEntity<Vehicle>(vehicleWriteService.updateVehicle(vehicle, id), HttpStatus.OK);
	}

	@PostMapping("/vehicle")
	public ResponseEntity<Vehicle> postVehicle(@RequestBody Vehicle vehicle) {
		return new ResponseEntity<Vehicle>(vehicleWriteService.addVehicle(vehicle), HttpStatus.CREATED);
	}

	@DeleteMapping("/vehicle/{id}")
	public ResponseEntity<String> deleteVehicle(@PathVariable int id) {
		boolean deleteVehicle = vehicleWriteService.deleteVehicle(id);
		if (deleteVehicle)
			return new ResponseEntity<String>("deleted successfully", HttpStatus.OK);
		else
			return new ResponseEntity<String>("resource not found", HttpStatus.NOT_FOUND);
	}
}
