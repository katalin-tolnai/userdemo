package com.example.demuser.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
@Data
@Entity
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;

}
