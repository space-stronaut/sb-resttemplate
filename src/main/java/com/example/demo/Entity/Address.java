package com.example.demo.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private Long userId;
    private String suite;
    private String street;
    private String city;
    private String zipcode;
}
