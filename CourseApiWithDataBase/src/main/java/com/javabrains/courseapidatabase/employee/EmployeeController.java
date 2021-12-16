package com.javabrains.courseapidatabase.employee;

import com.javabrains.courseapidatabase.department.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;

    @RequestMapping("/departments/{departmentId}/employees")
    public List<Employee> getEmployees(@PathVariable String departmentId) {

        return employeeService.getEmployees(departmentId);
    }


    @RequestMapping("/departments/{departmentId}/employees/{employeeId}")
    public Employee getEmployee(@PathVariable String employeeId) {

        return employeeService.getEmployee(employeeId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/departments/{departmentId}/employees")
    public void addEmployee(@RequestBody Employee employee, @PathVariable String departmentId) {
        employee.setDepartment(new Department(departmentId,""));
        employeeService.addEmployee( employee);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/departments/{departmentId}/employees/{employeeId}")
    public void updateEmployee( @RequestBody Employee employee,@PathVariable String departmentId) {
        employee.setDepartment(new Department(departmentId,""));

        employeeService.updateEmployee(employee);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/departments/{departmentId}/employees/{employeeId}")
    public void deleteEmployee(@PathVariable String employeeId) {

        employeeService.deleteEmployee(employeeId);
    }
}
