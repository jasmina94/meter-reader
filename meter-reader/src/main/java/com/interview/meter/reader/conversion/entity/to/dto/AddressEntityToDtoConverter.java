package com.interview.meter.reader.conversion.entity.to.dto;

import com.interview.meter.reader.conversion.MRConverter;
import com.interview.meter.reader.domain.AddressEntity;
import com.interview.meter.reader.dto.AddressDto;
import org.springframework.stereotype.Component;

@Component
public class AddressEntityToDtoConverter extends MRConverter<AddressEntity, AddressDto> {

    @Override
    public AddressDto convert(AddressEntity source) {
        var dto = new AddressDto();
        map(source, dto);
        return dto;
    }

    @Override
    public void map(AddressEntity sourceObject, AddressDto targetObject) {
        targetObject.setCity(sourceObject.getCity());
        targetObject.setLand(sourceObject.getLand());
        targetObject.setZip(sourceObject.getZipCode());
        targetObject.setStreet(sourceObject.getStreet());
        targetObject.setAdditionalAddress(sourceObject.getAdditionalAddress());
    }
}
