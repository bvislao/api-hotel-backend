package com.hotel.utp.project.infrastructure.repository.jpa;

import com.hotel.utp.project.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserJpaRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUuid(String uuid);
    UserEntity findByEmail(String email);
    UserEntity findByDocumentNumber(String documentNumber);
    UserEntity findByEmailAndPassword(String email, String password);
    List<UserEntity> findAllByStatusId(Integer StatusId);
}
