package com.hotel.utp.project.infrastructure.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto<T> {
    private String code;
    private String message;
    private HeaderDto header;
    private T response;
    @JsonIgnore
    private int statusCode;

    public ResponseDto(){}

    public ResponseDto(String code, String message, int statusCode){
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }
}
