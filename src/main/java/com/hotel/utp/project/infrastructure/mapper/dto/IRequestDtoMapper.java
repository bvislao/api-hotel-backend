package com.hotel.utp.project.infrastructure.mapper.dto;

import com.hotel.utp.project.domain.Header;
import com.hotel.utp.project.infrastructure.dto.response.HeaderDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.context.annotation.Primary;

@Primary
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IRequestDtoMapper {
    HeaderDto toDto(Header header);
}
