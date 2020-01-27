package com.idgenerali.mybackend.model;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductInsurance implements Serializable {

    private int id;
    private String name;
    private int categoryInsuranceId;
    private int statusId;

}
