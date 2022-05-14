package com.example.springxreact.Controllers;

import com.example.springxreact.Models.Vehicle;
import com.example.springxreact.Services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @GetMapping("/vehicles")
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> list = vehicleService.getAllListVehicle();
        return new ResponseEntity<List<Vehicle>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<Vehicle> getVehiclesById(@PathVariable Long id) {
        Vehicle vehicle;
        vehicle = vehicleService.getVehicleById(id);
        return new ResponseEntity<Vehicle>(vehicle, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/vehicles")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle){
        vehicle = vehicleService.saveVehicle(vehicle);
        return new ResponseEntity<Vehicle>(vehicle, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/vehicles/delete/{id}")
    public ResponseEntity<Vehicle> deleteVehicle(@PathVariable Long id){
        Vehicle vehicle;
        vehicle = vehicleService.deleteUsingSaveVehicle(id);
        return new ResponseEntity<Vehicle>(vehicle, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/vehicles")
    public ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle vehicle){
        vehicle = vehicleService.updateVehicle(vehicle);
        return new ResponseEntity<Vehicle>(vehicle, new HttpHeaders(), HttpStatus.OK);
    }
}
