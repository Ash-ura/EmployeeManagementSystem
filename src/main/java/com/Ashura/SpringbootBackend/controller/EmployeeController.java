package com.Ashura.SpringbootBackend.controller;

import com.Ashura.SpringbootBackend.exception.ResourceNotFoundException;
import com.Ashura.SpringbootBackend.model.Employee;
import com.Ashura.SpringbootBackend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ems")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    // build/create an employee entry
    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    // update an employee entry
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id") long employeeId){
        return new ResponseEntity<>(employeeService.updateEmployeeInfo(employee, employeeId), HttpStatus.OK);
    }

    // delete an employee entry
    @GetMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployee(Employee employee, @PathVariable("id") long employeeId) {
        ResponseEntity<Employee> responseEntity = new ResponseEntity<>(employeeService.deleteEmployee(employee, employeeId), HttpStatus.OK);
        return null;
    }

    // find all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getEmployees();
    }

    // find employee by id
    @GetMapping("/employee")
    public Employee getEmployee(@RequestParam("id") long id) throws ResourceNotFoundException {
        return employeeService.getEmployee(id);

    }
}
