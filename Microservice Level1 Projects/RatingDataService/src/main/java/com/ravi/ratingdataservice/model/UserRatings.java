package com.ravi.ratingdataservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserRatings {

    private List<Rating> ratingList;

}
