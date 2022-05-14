package com.example.springxreact.Controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.springxreact.Repositories.EmployeeRepository;
import com.example.springxreact.Models.Employee;



@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	
    @GetMapping(value = "/employees")
    public List<Employee> getAllEmployees(){
    	return employeeRepository.findAllActiveEmployees();
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee){
        employee.setStatus("1");
        return employeeRepository.save(employee);
    }

    @GetMapping("/employees/{id}")
    public Employee getById(@PathVariable Long id){
        return employeeRepository.findById(id).get();
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee){
        employee.setStatus("1");
        return employeeRepository.save(employee);
    }

    @PostMapping("/employees/delete/{id}")
    public Employee removeUsingUpdate(@PathVariable Long id){
        Employee employee = new Employee();
        List<Employee> employeeList = null;

        employeeList = null;
        employeeList = employeeRepository.findAllById(Collections.singleton(id));

        for (Employee g: employeeList) {
            employee.setName(g.getName());
            employee.setDepartment(g.getDepartment());
            employee.setLocation(g.getLocation());
            System.out.println(g);
        }
        employee.setId(id);
        employee.setStatus("0");
        return employeeRepository.save(employee);
    }



}
