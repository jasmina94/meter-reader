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
    public void map(AddressEntity source, AddressDto dto) {
        dto.setId(source.getId());
        dto.setStreet(source.getStreet());
        dto.setCity(source.getCity());
        dto.setZip(source.getZipCode());
        dto.setLand(source.getLand());
        dto.setAdditionalAddress(source.getAdditionalAddress());
    }
}
