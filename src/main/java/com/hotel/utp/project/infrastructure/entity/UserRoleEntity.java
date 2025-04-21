package com.hotel.utp.project.infrastructure.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users_role")
@Getter
@Setter
public class UserRoleEntity extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 36)
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "rol_id")
    private RolEntity rol;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private StatusEntity status;
}
