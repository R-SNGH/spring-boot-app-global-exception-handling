package com.crud.demo.controller;

import com.crud.demo.custom.exceptions.BusinessException;
import com.crud.demo.custom.exceptions.ControllerException;
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
        //
        System.out.println("returning all the employees in the DB....");
        List<Employee> employees=employeeServiceInterface.getAllEmployees();
        return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
    }

    @GetMapping("/all/{empid}")
    public ResponseEntity<?> getEmployee(@PathVariable("empid") Long empId){
//        try{
//            Employee employee=employeeServiceInterface.getEmployee(empId);
//            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
//        }catch(BusinessException e){
//            ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
//            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
//        }catch(Exception e){
//            ControllerException ce = new ControllerException("612","Something bad happened while fetching an employee in Controller Layer.");
//            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
//        }
        Employee employee = employeeServiceInterface.getEmployee(empId);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
//        try{
//            Employee savedEmployee = employeeServiceInterface.addEmployee(employee);
//            return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);
//        }catch(BusinessException e){
//            ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
//            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
//        }catch(Exception e){
//            ControllerException ce = new ControllerException("611","Something bad happened while adding employee in Controller Layer.");
//            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
//        }
        //Using ControllerAdvice : Global Exception Handling
        Employee savedEmployee = employeeServiceInterface.addEmployee(employee);
        return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{empid}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("empid") Long empid){
        employeeServiceInterface.deleteEmployee(empid);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updatedEmp = employeeServiceInterface.addEmployee(employee);
        return new ResponseEntity<Employee>(updatedEmp, HttpStatus.ACCEPTED);
    }
}
