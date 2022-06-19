package com.example.springxreact.Repositories;

import com.example.springxreact.Models.Vehicle;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query(value = "SELECT * FROM tbl_vehicles e WHERE e.status = 1", nativeQuery=true)
    List<Vehicle> findAllActiveVehicles();
}
