package com.hotel.utp.project.infrastructure.repository;

import com.hotel.utp.project.application.repository.IRequestRepository;
import com.hotel.utp.project.domain.Header;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@RequiredArgsConstructor
@Component
public class RequestRepository implements IRequestRepository {

    @Override
    public Header getResponseHeader(Date startDatetime, Date endDatetime) {
        return new Header(startDatetime, endDatetime);
    }
}
