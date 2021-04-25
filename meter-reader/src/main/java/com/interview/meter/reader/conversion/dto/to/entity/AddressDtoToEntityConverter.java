package com.interview.meter.reader.conversion.dto.to.entity;

import com.interview.meter.reader.conversion.MRConverter;
import com.interview.meter.reader.domain.AddressEntity;
import com.interview.meter.reader.dto.AddressDto;
import org.springframework.stereotype.Component;

@Component
public class AddressDtoToEntityConverter extends MRConverter<AddressDto, AddressEntity> {

    @Override
    public AddressEntity convert(AddressDto source) {
        var entity = new AddressEntity();
        map(source, entity);
        return entity;
    }

    @Override
    public void map(AddressDto sourceObject, AddressEntity targetObject) {
        targetObject.setCity(sourceObject.getCity());
        targetObject.setLand(sourceObject.getLand());
        targetObject.setZipCode(sourceObject.getZip());
        targetObject.setStreet(sourceObject.getStreet());
        targetObject.setAdditionalAddress(sourceObject.getAdditionalAddress());
    }
}
