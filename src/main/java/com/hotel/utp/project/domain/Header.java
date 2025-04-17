package com.hotel.utp.project.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class Header {
    @JsonProperty("transaction_start_datetime")
    private String transactionStartDatetime;
    @JsonProperty("transaction_end_datetime")
    private String transactionEndDatetime;
    private Long milis;

    public Header(Date startDatetime, Date endDatetime){
        String pattern = "dd/MM/yyyy HH:mm:ss.SSS";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(startDatetime);
        String dateEnd = simpleDateFormat.format(endDatetime);
        this.transactionStartDatetime = date;
        this.transactionEndDatetime = dateEnd;
        calculateDiff(startDatetime, endDatetime);
    }

    public void calculateDiff(Date startDatetime, Date endDatetime){
        this.milis = Math.abs(endDatetime.getTime() - startDatetime.getTime());
    }
}
