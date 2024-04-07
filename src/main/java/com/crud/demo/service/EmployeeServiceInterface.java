package com.crud.demo.service;

import com.crud.demo.entities.Employee;

import java.util.List;

public interface EmployeeServiceInterface {

    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployee(Long id);

    void deleteEmployee(Long empid);

//    Employee updateEmployee(Employee employee);
}
