package com.ravi.moviecatalogservice.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CatalogItem {

    private String name;
    private String language;
    private String desc;
    private int rating;
}
