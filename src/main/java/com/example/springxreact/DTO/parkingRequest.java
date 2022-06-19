package com.example.springxreact.DTO;

import com.example.springxreact.Models.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class parkingRequest {

    private Employee employee;
    
}
