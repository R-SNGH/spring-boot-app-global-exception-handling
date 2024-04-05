package com.crud.demo.controller;

import com.crud.demo.entities.Employee;
import com.crud.demo.repository.EmployeeRepository;
import com.crud.demo.service.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {
//    @Autowired
//    EmployeeRepository emprepo;

    @Autowired
    EmployeeServiceInterface employeeServiceInterface;

//    @GetMapping
//    public List<Employee> getAllEmployees(){
//        System.out.println("returning all the employees in the DB....");
////        return emprepo.findAll();
//    }
    @PostMapping("/save")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee savedEmployee = employeeServiceInterface.addEmployee(employee);
        return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);

    }

}
