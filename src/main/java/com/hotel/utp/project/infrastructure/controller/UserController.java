package com.hotel.utp.project.infrastructure.controller;

import com.hotel.utp.project.application.service.RequestService;
import com.hotel.utp.project.application.service.UserService;
import com.hotel.utp.project.domain.User;
import com.hotel.utp.project.infrastructure.constants.MessageCodes;
import com.hotel.utp.project.infrastructure.constants.StatusCodes;
import com.hotel.utp.project.infrastructure.dto.response.HeaderDto;
import com.hotel.utp.project.infrastructure.dto.response.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "user", produces = "application/json")
@RequiredArgsConstructor
@Tag(name = "Usuarios", description = "Gestión de Usuarios")
public class UserController {

    private final UserService userService;
    private final RequestService requestService;
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Operation(summary = "Healhcheck")
    @GetMapping("ping")
    public ResponseEntity<?> ping() {
        return new ResponseEntity<>("Endpoint works!", HttpStatus.OK);
    }

    @Operation(summary = "Get all users")
    @GetMapping("all")
    public ResponseEntity<ResponseDto<List<User>>> getAllUsers() {
        var response = new ResponseDto<List<User>>();
        try{
            Date startDatetime = Calendar.getInstance().getTime();
            List<User> users = userService.findAll();
            Date endDatetime = Calendar.getInstance().getTime();
            HeaderDto headerDto = requestService.getResponseHeader(startDatetime, endDatetime);
            response.setStatusCode(StatusCodes.Code201);
            response.setCode(MessageCodes.ResponseCodeS00);
            response.setMessage("Lista de Usuarios obtenida con éxito");
            response.setHeader(headerDto);
            response.setResponse(users);
            return ResponseEntity.status(response.getStatusCode()).body(response);

        }catch (Exception ex){
            logger.error(ex.getMessage(), ex);
            return ResponseEntity.status(StatusCodes.Code500).body(response);
        }
    }

    @Operation(summary = "Get user by email")
    @GetMapping("email")
    public ResponseEntity<ResponseDto<User>> getUserByEmail(String email) {
        var response = new ResponseDto<User>();
        try{
            Date startDatetime = Calendar.getInstance().getTime();
            User user = userService.findByEmail(email);
            Date endDatetime = Calendar.getInstance().getTime();
            HeaderDto headerDto = requestService.getResponseHeader(startDatetime, endDatetime);
            response.setStatusCode(StatusCodes.Code201);
            response.setCode(MessageCodes.ResponseCodeS00);
            response.setMessage("Usuario obtenido con éxito");
            response.setHeader(headerDto);
            response.setResponse(user);
            return ResponseEntity.status(response.getStatusCode()).body(response);

        }catch (Exception ex){
            logger.error(ex.getMessage(), ex);
            return ResponseEntity.status(StatusCodes.Code500).body(response);
        }
    }

}
