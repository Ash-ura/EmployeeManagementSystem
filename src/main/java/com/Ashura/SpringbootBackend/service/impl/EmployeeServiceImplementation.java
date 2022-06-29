package com.Ashura.SpringbootBackend.service.impl;

import com.Ashura.SpringbootBackend.exception.ResourceNotFoundException;
import com.Ashura.SpringbootBackend.model.Employee;
import com.Ashura.SpringbootBackend.repository.EmployeeRepository;
import com.Ashura.SpringbootBackend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(long id) throws ResourceNotFoundException {

        // longer implementation
//        Optional<Employee> employee = employeeRepository.findById(id);
//        if (employee.isPresent()){
//            return employee.get();
//        } else {
//            throw new ResourceNotFoundException("Employee", "Id", id);
//        }

        // shorter implementation(lambda)
        return employeeRepository.findById(id).orElseThrow(() ->
                new  ResourceNotFoundException("Employee", "Id", id));
    }

    @Override
    public Employee updateEmployeeInfo(Employee employee, long id) {

        // validate id
        Employee employeeExists = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "Id", id));

        // update details
        employeeExists.setFirstName(employee.getFirstName());
        employeeExists.setLastName(employee.getLastName());
        employeeExists.setEmail(employee.getEmail());

        // save to DB
        employeeRepository.save(employeeExists);

        return employeeExists;
    }

    @Override
    public Employee deleteEmployee(Employee employee, long id) {

        // validate id
        Employee employeeExists = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "Id", id));

        // delete from DB
        employeeRepository.delete(employeeExists);

        return employeeExists;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
}
