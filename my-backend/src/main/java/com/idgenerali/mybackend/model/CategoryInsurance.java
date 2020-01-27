package com.idgenerali.mybackend.model;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryInsurance implements Serializable {

    private int id;
    private String name;
    private int flagActive;
    private Date createdAt;
    private Date updatedAt;
}
