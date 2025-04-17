package com.hotel.utp.project.application.service;

import com.hotel.utp.project.application.repository.IRequestRepository;
import com.hotel.utp.project.domain.Header;
import com.hotel.utp.project.infrastructure.dto.response.HeaderDto;
import com.hotel.utp.project.infrastructure.mapper.dto.IRequestDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@RequiredArgsConstructor
@Service
public class RequestService {
    private final IRequestRepository requestRepository;
    private final IRequestDtoMapper requestDtoMapper;

    public HeaderDto getResponseHeader(Date startDatetime, Date endDatetime){
        Header header = requestRepository.getResponseHeader(startDatetime, endDatetime);
        return requestDtoMapper.toDto(header);
    }
}
