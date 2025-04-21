package com.hotel.utp.project.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseDescription {
    private Integer id;
    private String uuid;
    private String code;
    private String description;
    private Integer active;


    public BaseDescription(Integer id, String uuid,String code, String description, Integer active) {
        this.id = id;
        this.uuid = uuid;
        this.code = code;
        this.description = description;
        this.active = active;
    }
    public BaseDescription(Integer id, String uuid, String description, Integer active) {
        this.id = id;
        this.uuid = uuid;
        this.description = description;
        this.active = active;
    }
}
