package com.kirillkurko.taskmanager.model.service;

import com.kirillkurko.taskmanager.model.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    void save(Employee employee);

    Employee findById(int id);

    void deleteById(int id);
}
