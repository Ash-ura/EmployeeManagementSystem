package com.Ashura.SpringbootBackend.repository;

import com.Ashura.SpringbootBackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
