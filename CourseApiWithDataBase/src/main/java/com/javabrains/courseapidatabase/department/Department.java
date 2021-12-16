package com.javabrains.courseapidatabase.department;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@ApiModel(description = "Details about the contact")
public class Department {

    @Id
    @ApiModelProperty(notes = "The unique ID of the Department")
    private String id;
    @ApiModelProperty(notes = "The Name of the Department")
    private String name;

    public Department(String id, String name) {
        this.id = id;
        this.name = name;

    }

    public Department() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
     
}
