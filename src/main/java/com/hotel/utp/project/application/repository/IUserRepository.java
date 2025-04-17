package com.hotel.utp.project.application.repository;

import com.hotel.utp.project.domain.User;
import com.hotel.utp.project.domain.UserRole;

import java.util.List;

public interface IUserRepository {
    List<User> findAll();
    User findByEmail(String email);
    User findByDocumentNumber(String documentNumber);
    User findById(Integer id);
    User findByUuid(String uuid);
    UserRole assignRole(User user, Integer rolId);
    UserRole deleteRole(User user, Integer rolId);
    User createUser(User user);
    User updateUser(User user);
    User deleteUser(User user);


}
