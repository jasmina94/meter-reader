package com.interview.meter.reader.dto;

import lombok.Data;

@Data
public class MeterDto {

    private Long id;
    private String name;
    private ClientDto clientDto;
}
