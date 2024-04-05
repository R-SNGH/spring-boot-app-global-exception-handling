package com.crud.demo.service;

import com.crud.demo.entities.Employee;
import com.crud.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements EmployeeServiceInterface{

    @Autowired
    EmployeeRepository emprepo;


    @Override
    public Employee addEmployee(Employee employee) {
        Employee e=emprepo.save(employee);
        return e;
    }
}
