package com.javabrains.courseapidatabase.employee;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,String> {

    public List<Employee> findByDepartmentId(String id);
}
