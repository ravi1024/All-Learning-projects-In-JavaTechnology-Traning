package com.javabrains.courseapidatabase.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getDepartments() {

        List<Department> departmentList = new ArrayList<>();
        departmentRepository.findAll()
        .forEach(e -> departmentList.add(e));
        return departmentList;
    }

    public Department getDepartment(String id) {
        return departmentRepository.findById(id).get();
    }

    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }

    public void updateDepartment(String id, Department department) {
        departmentRepository.save(department);
    }

    public void deleteDepartment(String id) {
        departmentRepository.deleteById(id);
    }
}
