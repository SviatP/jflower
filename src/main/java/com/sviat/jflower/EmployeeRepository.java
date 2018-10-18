package com.sviat.jflower;

import org.springframework.data.repository.CrudRepository;

import com.sviat.jflower.domain.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
