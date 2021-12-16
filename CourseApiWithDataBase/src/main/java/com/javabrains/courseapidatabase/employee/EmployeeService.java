package com.javabrains.courseapidatabase.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(String id) {

        List<Employee> employeeList = new ArrayList<>();
        employeeRepository.findByDepartmentId(id)
        .forEach(e -> employeeList.add(e));
        return employeeList;
    }

    public Employee getEmployee(String id) {
        return employeeRepository.findById(id).get();
    }

    public void addEmployee( Employee employee) {
        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(String id) {

        employeeRepository.deleteById(id);
    }
}
