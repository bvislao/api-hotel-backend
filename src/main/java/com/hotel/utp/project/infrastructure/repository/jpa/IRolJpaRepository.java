package com.hotel.utp.project.infrastructure.repository.jpa;

import com.hotel.utp.project.infrastructure.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolJpaRepository  extends JpaRepository<RolEntity, Integer> {
}
