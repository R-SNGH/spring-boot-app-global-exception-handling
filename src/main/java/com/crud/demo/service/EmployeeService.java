package com.crud.demo.service;

import com.crud.demo.entities.Employee;
import com.crud.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterface{

    @Autowired
    EmployeeRepository emprepo;

    @Override
    public Employee addEmployee(Employee employee) {
        Employee savedEmployee=emprepo.save(employee);
        return savedEmployee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return emprepo.findAll();
    }

    @Override
    public Employee getEmployee(Long id) {
        return emprepo.findById(id).get();//findById always returns an Optional.
    }

    @Override
    public void deleteEmployee(Long empid) {
        emprepo.deleteById(empid);
    }
}
