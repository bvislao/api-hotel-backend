package com.hotel.utp.project.infrastructure.repository.jpa;

import com.hotel.utp.project.infrastructure.entity.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStatusJpaRepository  extends JpaRepository<StatusEntity, Integer> {
}
