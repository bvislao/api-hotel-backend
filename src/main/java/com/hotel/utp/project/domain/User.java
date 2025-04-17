package com.hotel.utp.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class User{
    private Integer id;
    private String uuid;
    private String documentNumber;
    private String fullName;
    private String email;
    private String password;

    public User(Integer id, String uuid, String documentNumber, String fullName, String email, String password) {
        this.id = id;
        this.uuid = uuid;
        this.documentNumber = documentNumber;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

}
