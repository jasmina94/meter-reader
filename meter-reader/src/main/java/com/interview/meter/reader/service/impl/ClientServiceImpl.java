package com.interview.meter.reader.service.impl;

import com.interview.meter.reader.conversion.MRConversionService;
import com.interview.meter.reader.domain.ClientEntity;
import com.interview.meter.reader.dto.ClientDto;
import com.interview.meter.reader.repository.ClientRepository;
import com.interview.meter.reader.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final MRConversionService conversionService;

    @Override
    public ClientDto getClient(String firstname) {
        ClientEntity clientEntity = clientRepository.findFirstByFirstName(firstname);
        return conversionService.convert(clientEntity, ClientDto.class);
    }
}
