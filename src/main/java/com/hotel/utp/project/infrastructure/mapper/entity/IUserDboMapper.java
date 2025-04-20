package com.hotel.utp.project.infrastructure.mapper.entity;

import com.hotel.utp.project.domain.User;
import com.hotel.utp.project.domain.UserRole;
import com.hotel.utp.project.infrastructure.entity.UserEntity;
import com.hotel.utp.project.infrastructure.entity.UserRoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;
import org.springframework.context.annotation.Primary;

@Primary
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IUserDboMapper {
    @Mappings({
            @Mapping(target = "createdBy", ignore = true),
            @Mapping(target = "createdDate", ignore = true),
            @Mapping(target = "lastModifiedBy", ignore = true),
            @Mapping(target = "lastModifiedDate", ignore = true),
    })
    UserEntity toDbo(User user);

    User toDomain(UserEntity user);

    @Mappings({
            @Mapping(target = "user", ignore = true),
            @Mapping(target = "status", ignore = true),
    })
    UserRoleEntity toDbo(UserRole user);

    @Mapping(target = "status", ignore = true)
    UserRole toDomain(UserRoleEntity userRole);
}
