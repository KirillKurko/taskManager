package com.kirillkurko.taskmanager.model.service.implementation;

import com.kirillkurko.taskmanager.model.entity.Employee;
import com.kirillkurko.taskmanager.model.repository.EmployeeRepository;
import com.kirillkurko.taskmanager.model.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        else {
            throw new RuntimeException("Employee with id = " + id + " not found");
        }
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
