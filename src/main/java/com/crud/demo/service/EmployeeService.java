package com.crud.demo.service;

import com.crud.demo.custom.exceptions.BusinessException;
import com.crud.demo.custom.exceptions.EmptyInputException;
import com.crud.demo.entities.Employee;
import com.crud.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeService implements EmployeeServiceInterface{

    @Autowired
    EmployeeRepository emprepo;

    @Override
    public Employee addEmployee(Employee employee) {
//        try{
//            //if name is null
//            if(employee.getName().isEmpty() || employee.getName().length()==0){
//                //when using custom exceptions, use a code not in use
//                throw new BusinessException("601","Please send a proper name. Name is blank.");
//                throw new EmptyInputException("601","Please send a proper name. Name is blank.");
//            }
//            Employee savedEmployee=emprepo.save(employee);
//            return savedEmployee;
//        }catch(IllegalArgumentException exception){
//            throw new BusinessException("602","Given employee is null: "+exception.getMessage());
//        }
//        catch(Exception exception){
//            throw new BusinessException("603","Oops! Something went wrong in Service Layer: "+exception.getMessage());
//        }
        if(employee.getName().isEmpty() || employee.getName().length()==0){
            throw new EmptyInputException("601","Please send a proper name. Name is blank.");
        }
        Employee savedEmployee=emprepo.save(employee);
        return savedEmployee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        //when whole list is empty
        try{
            List<Employee> employees = emprepo.findAll();
            if(employees.isEmpty()){
                throw new BusinessException("604","No employees in DB.");
            }
            return employees;
        }catch(Exception exception){
            throw new BusinessException("605","Something went wrong in Service Layer while fetching all employees: "+exception.getMessage());
        }
    }

    @Override
    public Employee getEmployee(Long id) {
//        try{
//            return emprepo.findById(id).get();//findById always returns an Optional.
//        }catch(IllegalArgumentException exception){
//            throw new BusinessException("606","Given employee ID is null. Please send an id. "+exception.getMessage());
//        }catch(NoSuchElementException exception){
//            throw new BusinessException("607","Given employee ID does not exist in DB: "+exception.getMessage());
//        }
        return emprepo.findById(id).get();//findById always returns an Optional.
    }

    @Override
    public void deleteEmployee(Long empid) {
        try{
            emprepo.deleteById(empid);
        }catch(IllegalArgumentException exception){
            throw new BusinessException("608","Supplied ID is invalid: "+ exception.getMessage());
        }
    }
}
