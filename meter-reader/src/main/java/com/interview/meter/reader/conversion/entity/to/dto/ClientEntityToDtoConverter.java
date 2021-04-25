package com.interview.meter.reader.conversion.entity.to.dto;

import com.interview.meter.reader.conversion.MRConverter;
import com.interview.meter.reader.domain.ClientEntity;
import com.interview.meter.reader.dto.AddressDto;
import com.interview.meter.reader.dto.ClientDto;
import org.springframework.stereotype.Component;

@Component
public class ClientEntityToDtoConverter extends MRConverter<ClientEntity, ClientDto> {

    @Override
    public ClientDto convert(ClientEntity source) {
        var dto = new ClientDto();
        map(source, dto);
        return dto;
    }

    @Override
    public void map(ClientEntity sourceObject, ClientDto targetObject) {
        targetObject.setLastName(sourceObject.getLastName());
        targetObject.setFirstName(sourceObject.getFirstName());
        targetObject.setAddressDto(conversionService.convert(sourceObject.getAddressEntity(), AddressDto.class));
    }

}
