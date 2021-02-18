package com.kirillkurko.taskmanager.controller;

import com.kirillkurko.taskmanager.model.entity.Employee;
import com.kirillkurko.taskmanager.model.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee employee = new Employee();
        try {
            employee = employeeService.findById(employeeId);
        }
        catch (RuntimeException exception) {
            exception.printStackTrace();
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        employeeService.save(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        try {
            employeeService.findById(employeeId);
            employeeService.deleteById(employeeId);
            return "Deleted employee id - " + employeeId;
        }
        catch (RuntimeException exception) {
            exception.printStackTrace();
        }
        return "Employee with id - " + employeeId + " not found";
    }
}
