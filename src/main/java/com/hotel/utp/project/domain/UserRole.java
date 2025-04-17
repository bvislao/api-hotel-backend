package com.hotel.utp.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRole {
    private Integer id;
    private String uuid;
    private User user;
    private Rol rol;
    private Integer status;
}
