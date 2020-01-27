package com.idgenerali.mybackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Leads implements Serializable {

    private int id;
    private String name;
    private String email;
    private boolean active;
}
