package com.interview.meter.reader.dto;

import lombok.Data;

@Data
public class ClientDto {

    private String firstName;
    private String lastName;
    private AddressDto addressDto;

}