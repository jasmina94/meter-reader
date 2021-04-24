package com.interview.meter.reader.dto;

import com.interview.meter.reader.enums.Month;
import com.interview.meter.reader.enums.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReadingDto {

    private Long id;
    private int year;
    private double level;
    private Month month;
    private Status status;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
