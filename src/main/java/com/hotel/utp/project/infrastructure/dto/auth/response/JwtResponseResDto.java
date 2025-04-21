package com.hotel.utp.project.infrastructure.dto.auth.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class JwtResponseResDto {
    private String uuid;
    private String userName;
    private String token;
    private String type = "Bearer";
    private List<String> roles;

    public JwtResponseResDto(String uuid, String userName, String token, List<String> roles) {
        this.uuid = uuid;
        this.userName = userName;
        this.token = token;
        this.roles = roles;
    }
}
