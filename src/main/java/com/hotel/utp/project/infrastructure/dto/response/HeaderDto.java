package com.hotel.utp.project.infrastructure.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeaderDto {
    @JsonProperty("transaction_start_datetime")
    private String transactionStartDatetime;
    @JsonProperty("transaction_end_datetime")
    private String transactionEndDatetime;
    private Long milis;
}
