package com.idgenerali.mybackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestResponse<T> {

    private Date timestamp;
    private String message;
    private String status;
    private T data;

}
