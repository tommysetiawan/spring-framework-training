package com.blibli.test.blogapp.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Created by tommy.setiawan on 3/12/2020.
 */
@Data
@Builder
public class UserRequest {
    private String name;
    private String email;
    private Integer age;
}
