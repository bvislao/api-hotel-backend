package com.hotel.utp.project.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rol extends BaseDescription {
    public Rol(Integer id, String uuid, String description, Integer status) {
        super(id, uuid, description, status);
    }
}
