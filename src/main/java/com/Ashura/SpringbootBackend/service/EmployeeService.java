package com.Ashura.SpringbootBackend.service;

import com.Ashura.SpringbootBackend.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    Employee getEmployee(long id);
    Employee updateEmployeeInfo(Employee employee, long id);
    Employee deleteEmployee(Employee employee, long id);
    List<Employee> getEmployees();
}
