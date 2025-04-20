package com.hotel.utp.project.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Status {
    private Integer id;
    private String uuid;
    private String description;
    private Integer active;

    public Status(Integer id){
        this.id = id;
    }
}
