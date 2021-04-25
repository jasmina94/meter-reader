package com.interview.meter.reader.conversion.entity.to.dto;

import com.interview.meter.reader.conversion.MRConverter;
import com.interview.meter.reader.domain.MeterEntity;
import com.interview.meter.reader.dto.ClientDto;
import com.interview.meter.reader.dto.MeterDto;
import org.springframework.stereotype.Component;

@Component
public class MeterEntityToDtoConverter extends MRConverter<MeterEntity, MeterDto> {

    @Override
    public MeterDto convert(MeterEntity source) {
        var dto = new MeterDto();
        map(source, dto);
        return dto;
    }

    @Override
    public void map(MeterEntity sourceObject, MeterDto targetObject) {
        targetObject.setName(sourceObject.getName());
        targetObject.setClientDto(conversionService.convert(sourceObject.getClientEntity(), ClientDto.class));
    }
}
