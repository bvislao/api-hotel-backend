package com.hotel.utp.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class User{
    private Integer id;
    private String uuid;
    private String documentNumber;
    private String fullName;
    private String phone;
    private String email;
    private String password;
    private Status status;
    private List<Rol> roles;

}
