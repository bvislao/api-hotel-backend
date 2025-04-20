package com.hotel.utp.project.infrastructure.repository.jpa;

import com.hotel.utp.project.infrastructure.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRoleJpaRepository extends JpaRepository<UserRoleEntity, Integer> {
}
