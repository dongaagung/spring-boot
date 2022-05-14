package com.example.springxreact.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springxreact.Models.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    @Query(value = "SELECT * FROM tbl_employees e WHERE e.status = 1", nativeQuery=true)
    List<Employee> findAllActiveEmployees();

}
