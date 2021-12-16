package com.javabrains.courseapidatabase.employee;

import com.javabrains.courseapidatabase.department.Department;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employee {

    @Id
    private String id;
    private String name;
    private String email;
    private String contact;

    @ManyToOne
    private Department department;

    public Employee(String id, String name, String email, String contact,String departmentId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.department= new Department(departmentId,"");
    }

    public Employee() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
