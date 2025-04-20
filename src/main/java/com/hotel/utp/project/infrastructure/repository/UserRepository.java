package com.hotel.utp.project.infrastructure.repository;

import com.hotel.utp.project.application.repository.IUserRepository;
import com.hotel.utp.project.domain.Rol;
import com.hotel.utp.project.domain.User;
import com.hotel.utp.project.domain.UserRole;
import com.hotel.utp.project.infrastructure.entity.UserEntity;
import com.hotel.utp.project.infrastructure.mapper.entity.IUserDboMapper;
import com.hotel.utp.project.infrastructure.repository.jpa.IUserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class UserRepository implements IUserRepository {

    private final IUserDboMapper userDboMapper;
    private final IUserJpaRepository userJpaRepository;

    private final List<User> users = new ArrayList<>();

    @Override
    public List<User> findAll() {
        List<UserEntity> userListEntity = userJpaRepository.findAll();
        List<User> users = new ArrayList<>();
        for (UserEntity userEntity : userListEntity) {
            users.add(userDboMapper.toDomain(userEntity));
        }
        return users;
    }

    @Override
    public User findByEmail(String email) {
       return null;
    }

    @Override
    public User findByDocumentNumber(String documentNumber) {
        return null;
    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public User findByUuid(String uuid) {
        return null;
    }

    @Override
    public UserRole assignRole(User user, Integer rolId) {
        return null;
    }

    @Override
    public UserRole deleteRole(User user, Integer rolId) {
        return null;
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public User deleteUser(User user) {
        return null;
    }
}
