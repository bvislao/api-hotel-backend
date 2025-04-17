package com.hotel.utp.project.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseDescription {
    private Integer id;
    private String uuid;
    private String description;
    private Integer status;

    public BaseDescription(Integer id, String uuid, String description, Integer status) {
    }
}
