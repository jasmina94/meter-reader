package com.interview.meter.reader.dto;

import lombok.Data;

@Data
public class AddressDto {

    private String street;
    private String additionalAddress;
    private String zip;
    private String city;
    private String land;
}
