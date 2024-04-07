package com.crud.demo.controller;

import com.crud.demo.entities.Employee;
import com.crud.demo.service.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    EmployeeServiceInterface employeeServiceInterface;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        System.out.println("returning all the employees in the DB....");
        List<Employee> employees=employeeServiceInterface.getAllEmployees();
        return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
    }

    @GetMapping("/all/{empid}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("empid") Long empId){
        System.out.println("returning the employee: ");
        Employee employee=employeeServiceInterface.getEmployee(empId);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee savedEmployee = employeeServiceInterface.addEmployee(employee);
        return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);

    }

    @DeleteMapping("/delete/{empid}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("empid") Long empid){
        employeeServiceInterface.deleteEmployee(empid);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> deleteEmployee(@RequestBody Employee employee){
        Employee updatedEmp = employeeServiceInterface.addEmployee(employee);
        return new ResponseEntity<Employee>(updatedEmp, HttpStatus.ACCEPTED);
    }
}
