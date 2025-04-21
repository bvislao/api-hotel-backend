package com.hotel.utp.project.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.HashSet;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserEntity extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 36)
    private String uuid;


    @Column(name = "document_number")
    private String documentNumber;
    @Column(name = "full_name")
    private String fullName;
    private String phone;
    private String email;
    private String password;
    @ManyToOne
    @JoinColumn(name = "status_id",referencedColumnName = "id")
    private StatusEntity status;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST,
                    CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(name = "users_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id"))
    private Collection<RolEntity> roles = new HashSet<>();

}
