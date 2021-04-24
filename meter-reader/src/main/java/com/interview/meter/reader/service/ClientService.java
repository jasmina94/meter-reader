package com.interview.meter.reader.service;

import com.interview.meter.reader.dto.ClientDto;

public interface ClientService {

    ClientDto getClient(String firstname);
}
