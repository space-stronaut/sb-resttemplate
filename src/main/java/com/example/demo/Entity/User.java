package com.example.demo.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String username;
    private String name;
    private String email;
    private String phone;
    private String website;
    private Address address;
}
