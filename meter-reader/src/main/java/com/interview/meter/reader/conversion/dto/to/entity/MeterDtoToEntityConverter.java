package com.interview.meter.reader.conversion.dto.to.entity;

import com.interview.meter.reader.conversion.MRConverter;
import com.interview.meter.reader.domain.ClientEntity;
import com.interview.meter.reader.domain.MeterEntity;
import com.interview.meter.reader.dto.MeterDto;
import org.springframework.stereotype.Component;

@Component
public class MeterDtoToEntityConverter extends MRConverter<MeterDto, MeterEntity> {

    @Override
    public MeterEntity convert(MeterDto source) {
        var entity = new MeterEntity();
        map(source, entity);
        return entity;
    }

    @Override
    public void map(MeterDto sourceObject, MeterEntity targetObject) {
        targetObject.setName(sourceObject.getName());
        targetObject.setClientEntity(conversionService.convert(sourceObject.getClientDto(), ClientEntity.class));
    }
}
