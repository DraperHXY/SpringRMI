package com.draper.model;


import lombok.Data;

@Data
public class User {

    private long id;

    private long createAt;

    private long updateAt;

    private String name;

    private String phone;

    private String email;

    private String password;

}
