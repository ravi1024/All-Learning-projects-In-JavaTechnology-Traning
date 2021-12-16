package com.javabrains.courseapidatabase;


import com.javabrains.courseapidatabase.department.Department;
import com.javabrains.courseapidatabase.department.DepartmentRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DepartmentTests {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    @Order(1)
    public void testCreate() {
        Department department =new Department();
        department.setId("testDep01");
        department.setName("testIT");
        departmentRepository.save(department);
        Assertions.assertNotNull(departmentRepository.findById("testDep01").get());
    }

    @Test
    @Order(2)
    public void testReadAll() {
        List<Department> list = new ArrayList<>();
        departmentRepository.findAll()
                .forEach(list::add);
        Assertions.assertTrue(list.size() > 1);

    }

    @Test
    @Order(3)
    public void testRead() {
        Department department =departmentRepository.findById("testDep01").get();
        Assertions.assertEquals("testIT", department.getName());
    }

    @Test
    @Order(4)
    public void testUpdate () {
        Department department =departmentRepository.findById("testDep01").get();
        department.setName("UpdatedViaTestUnitDepName");
        departmentRepository.save(department);
        Assertions.assertNotEquals("testIT", departmentRepository.findById("testDep01").get().getName());
    }

    @Test
    @Order(5)
    public void testDelete () {
        departmentRepository.deleteById("testDep01");
        Assertions.assertFalse(departmentRepository.existsById("testDep01"));
//        assertThat(departmentRepository.existsById("testDep01")).isFalse();
    }

}
