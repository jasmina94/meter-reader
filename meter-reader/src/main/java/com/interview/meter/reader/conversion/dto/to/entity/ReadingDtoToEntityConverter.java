package com.interview.meter.reader.conversion.dto.to.entity;

import com.interview.meter.reader.conversion.MRConverter;
import com.interview.meter.reader.domain.MeterEntity;
import com.interview.meter.reader.domain.ReadingEntity;
import com.interview.meter.reader.dto.ReadingDto;
import org.springframework.stereotype.Component;

@Component
public class ReadingDtoToEntityConverter extends MRConverter<ReadingDto, ReadingEntity> {

    @Override
    public ReadingEntity convert(ReadingDto source) {
        var entity = new ReadingEntity();
        map(source, entity);
        return entity;
    }

    @Override
    public void map(ReadingDto sourceObject, ReadingEntity targetObject) {
        targetObject.setYear(sourceObject.getYear());
        targetObject.setMonth(sourceObject.getMonth());
        targetObject.setLevel(sourceObject.getLevel());
        targetObject.setStatus(sourceObject.getStatus());
        targetObject.setCreatedOn(sourceObject.getCreatedOn());
        targetObject.setUpdatedOn(sourceObject.getUpdatedOn());
        targetObject.setMeter(conversionService.convert(sourceObject.getMeterDto(), MeterEntity.class));
    }
}
