package com.blibli.test.blogapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tommy.setiawan on 3/12/2020.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteUserResponse {
    private boolean success;
    private String errorMessage;
}
