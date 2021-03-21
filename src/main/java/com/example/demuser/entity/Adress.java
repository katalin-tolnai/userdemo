package com.example.demuser.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Adress {

    @Id
    private String id;

    private String city;

    private String street;
    @Column(name = "house_nr")
    private int houseNr;
    @Column(name = "apartment_nr")
    private String apartmentNr;
    @Column(name = "zip_code")
    private int zipCode;
}
