package com.hotel.utp.project.application.repository;

import com.hotel.utp.project.domain.Header;

import java.util.Date;

public interface IRequestRepository {
    Header getResponseHeader(Date startDatetime, Date endDatetime);
}
