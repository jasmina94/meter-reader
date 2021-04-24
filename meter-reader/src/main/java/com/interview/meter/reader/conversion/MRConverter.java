package com.interview.meter.reader.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;

import javax.annotation.PostConstruct;

public abstract class MRConverter<S, T> implements Converter<S, T> {

    protected MRConversionService conversionService;

    public abstract void map(S sourceObject,T targetObject);

    @Lazy
    @Autowired
    public void setConversionService(MRConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @PostConstruct
    public void register() {
        conversionService.addConverter(this);
    }
}
