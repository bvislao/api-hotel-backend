package com.hotel.utp.project.infrastructure.controller;

import com.hotel.utp.project.application.service.RequestService;
import com.hotel.utp.project.infrastructure.config.jwt.JwtUtils;
import com.hotel.utp.project.infrastructure.config.user.HotelUserDetails;
import com.hotel.utp.project.infrastructure.dto.auth.request.LoginReqDto;
import com.hotel.utp.project.infrastructure.dto.auth.response.JwtResponseResDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "auth", produces = "application/json")
@RequiredArgsConstructor
@Tag(name = "Autorizador", description = "Autenticador y autorizador")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final RequestService requestService;
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Operation(summary = "healthchecks")
    @GetMapping("ping")
    public ResponseEntity<?> ping() {
        return new ResponseEntity<>("Endpoint works!", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginReqDto request) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtTokenForUser(authentication);
        HotelUserDetails userDetails = (HotelUserDetails) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority).toList();
        return ResponseEntity.ok(new JwtResponseResDto(
                userDetails.getUuid(),
                userDetails.getDocumentNumber(),
                jwt,
                roles));
    }

}
