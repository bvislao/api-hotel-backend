package com.hotel.utp.project.infrastructure.dto.auth.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginReqDto {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
