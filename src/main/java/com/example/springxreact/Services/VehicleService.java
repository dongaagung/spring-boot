package com.example.springxreact.Services;

import com.example.springxreact.Models.Vehicle;
import com.example.springxreact.Repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    public List<Vehicle> getAllListVehicle(){
        List<Vehicle> vehicleList = vehicleRepository.findAll();

        if(vehicleList.size() > 0) {
            return vehicleList;
        } else {
            return new ArrayList<Vehicle>();
        }
    }

    public Vehicle updateVehicle(Vehicle vehicle){
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(vehicle.getId());
        if (optionalVehicle.isPresent()){
            vehicle.setStatus("1");
            vehicleRepository.save(vehicle);
            return vehicle;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "not found");
        }
    }

    public Vehicle getVehicleById(Long id){
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(id);
        if (optionalVehicle.isPresent()){
            return vehicleRepository.findById(id).get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "not found");
        }
    }

    public Vehicle saveVehicle(Vehicle vehicle){
        vehicle.setStatus("1");
        return vehicleRepository.save(vehicle);
    }

    public Vehicle deleteUsingSaveVehicle(Long id){
        Vehicle vehicle = new Vehicle();
        List<Vehicle> vehicleList = null;

        vehicleList = null;
        vehicleList = vehicleRepository.findAllById(Collections.singleton(id));

        for (Vehicle g: vehicleList) {
            vehicle.setType(g.getType());
            vehicle.setPlateNumber(g.getPlateNumber());
        }
        vehicle.setId(id);
        vehicle.setStatus("0");
        return vehicleRepository.save(vehicle);
    }

    public Vehicle getByIdVehicle(Long id) {
        Optional<Vehicle> employee = vehicleRepository.findById(id);
        if (employee.isPresent()) {
            return vehicleRepository.getById(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "not found");
        }
    }

}
