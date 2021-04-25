package com.interview.meter.reader.conversion.dto.to.entity;

import com.interview.meter.reader.conversion.MRConverter;
import com.interview.meter.reader.domain.AddressEntity;
import com.interview.meter.reader.domain.ClientEntity;
import com.interview.meter.reader.dto.ClientDto;
import org.springframework.stereotype.Component;

@Component
public class ClientDtoToEntityConverter extends MRConverter<ClientDto, ClientEntity> {

    @Override
    public ClientEntity convert(ClientDto source) {
        var entity = new ClientEntity();
        map(source, entity);
        return entity;
    }

    @Override
    public void map(ClientDto sourceObject, ClientEntity targetObject) {
        targetObject.setLastName(sourceObject.getLastName());
        targetObject.setFirstName(sourceObject.getFirstName());
        targetObject.setAddressEntity(conversionService.convert(sourceObject.getAddressDto(), AddressEntity.class));
    }
}
