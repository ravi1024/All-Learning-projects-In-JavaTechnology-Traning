package com.javabrains.courseapidatabase.department;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    public DepartmentService departmentService;

    @RequestMapping("/departments")
    public List<Department> getDepartments() {

        return departmentService.getDepartments();
    }


    @RequestMapping("/departments/{id}")
    @ApiOperation(value = "Find Department by id",
                    notes = "Provide an id to look up specific contact from the Department Table",
                    response = Department.class)
    public Department getDepartment(@ApiParam(value = "ID value for the Department you need to retrieve", required = true) @PathVariable String id) {
        return departmentService.getDepartment(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/departments")
    public void addDepartment(@RequestBody Department department) {
        departmentService.addDepartment(department);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/departments/{id}")
    public void updateDepartment(@PathVariable String id, @RequestBody Department department) {

        departmentService.updateDepartment(id,department);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/departments/{id}")
    public void deleteDepartment(@PathVariable String id) {
        departmentService.deleteDepartment(id);
    }
}
