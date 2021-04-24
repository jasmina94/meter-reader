package com.interview.meter.reader.conversion;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Facade for {@link ConversionService}
 */
@Component
@RequiredArgsConstructor
public class MRConversionService {

    @Qualifier(value = "defaultConversionService")
    private final ConversionService conversionService;

    public <S, T> List<T> convert(final Collection<S> sourceObjects, final Class<T> targetType) {
        List<T> targetObjects = new ArrayList<>();
        if (CollectionUtils.isEmpty(sourceObjects)) {

        } else {
            String targetClassName = targetType.getSimpleName();
            for (S sourceObject : sourceObjects) {
                T targetObject = convert(sourceObject, targetType);
                if (targetObject != null) {
                    targetObjects.add(targetObject);
                }
            }
        }

        return targetObjects;
    }

    public  <T> T convert(final Object sourceObject, final Class<T> targetType) {
        T targetObject = null;
        if (sourceObject == null) {
            System.out.println("Log empty object");
            targetObject = null;
        } else {
            String sourceClassName = sourceObject.getClass().getSimpleName();
            String targetClassName = targetType.getSimpleName();
            System.out.println("Converting from " + sourceClassName + " to " + targetClassName);
            try {
                targetObject = conversionService.convert(sourceObject, targetType);
            } catch (ConversionFailedException e) {
                System.out.println("Log exception");
            }

        }

        return targetObject;
    }

    public void addConverter(Converter<?, ?> converter) {
        if (conversionService instanceof GenericConversionService) {
            ((GenericConversionService) conversionService).addConverter(converter);
        }
    }
}
