package com.interview.meter.reader.conversion.entity.to.dto;

import com.interview.meter.reader.conversion.MRConverter;
import com.interview.meter.reader.domain.ReadingEntity;
import com.interview.meter.reader.dto.MeterDto;
import com.interview.meter.reader.dto.ReadingDto;
import org.springframework.stereotype.Component;

@Component
public class ReadingEntityToDtoConverter extends MRConverter<ReadingEntity, ReadingDto> {

    @Override
    public ReadingDto convert(ReadingEntity source) {
        var dto = new ReadingDto();
        map(source, dto);
        return dto;
    }

    @Override
    public void map(ReadingEntity sourceObject, ReadingDto targetObject) {
        targetObject.setYear(sourceObject.getYear());
        targetObject.setLevel(sourceObject.getLevel());
        targetObject.setMonth(sourceObject.getMonth());
        targetObject.setStatus(sourceObject.getStatus());
        targetObject.setCreatedOn(sourceObject.getCreatedOn());
        targetObject.setUpdatedOn(sourceObject.getUpdatedOn());
        targetObject.setMeterDto(conversionService.convert(sourceObject.getMeter(), MeterDto.class));
    }
}
