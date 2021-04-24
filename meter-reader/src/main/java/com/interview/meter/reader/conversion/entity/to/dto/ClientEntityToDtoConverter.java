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
    public void map(ClientEntity source, ClientDto dto) {
        dto.setId(source.getId());
        dto.setFirstName(source.getFirstName());
        dto.setLastName(source.getLastName());
        dto.setAddressDto(conversionService.convert(source.getAddressEntity(), AddressDto.class));
    }

}
