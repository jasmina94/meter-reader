package com.interview.meter.reader.conversion;

import com.interview.meter.reader.exception.MRInternalException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
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
 * Wrapper service around {@link ConversionService}
 * Expand conversion functionality to work with collections.
 * (Decorator patter)
 */
@Log4j2
@Component
@RequiredArgsConstructor
public class MRConversionService {

    //@Qualifier(value = "defaultConversionService")
    private final ConversionService conversionService;

    /**
     * Convert the given collection of {@code sourceObjects} to a list of specified {@code targetType} objects.
     *
     * @param sourceObjects a collection of source objects to convert (may be {@code null})
     * @param targetType the target type to convert to (required)
     * @return the list of converted objects, instances of targetType
     * @throws MRInternalException if a conversion exception occurs.
     */
    public <S, T> List<T> convert(final Collection<S> sourceObjects, final Class<T> targetType) {
        List<T> targetObjects = new ArrayList<>();
        if (CollectionUtils.isEmpty(sourceObjects)) {
            LOGGER.debug("Source objects collection is empty. Returning empty list.");
        } else {
            String targetClassName = targetType.getSimpleName();
            LOGGER.debug(String.format("Converting source objects to %s...", targetClassName));
            for (S sourceObject : sourceObjects) {
                T targetObject = convert(sourceObject, targetType);
                if (targetObject != null) {
                    targetObjects.add(targetObject);
                }
            }
            LOGGER.debug(String.format("Converted source objects to %s.", targetClassName));
        }

        return targetObjects;
    }

    /**
     * Convert the given {@code source} to the specified {@code targetType}.
     * Method rethrows exception so actual cause of unsuccessful conversion is visible in stack trace.
     *
     * @param sourceObject the source object to be converted (may be {@code null})
     * @param targetType the target object to convert to (required)
     * @return the converted object, an instance of target type
     * @throws MRInternalException if a conversion exception occurs.
     */
    public  <T> T convert(final Object sourceObject, final Class<T> targetType) {
        final T targetObject;
        if (sourceObject == null) {
            LOGGER.debug("Source object is null. Returning null.");
            targetObject = null;
        } else {
            String sourceClassName = sourceObject.getClass().getSimpleName();
            String targetClassName = targetType.getSimpleName();
            try {
                LOGGER.debug(String.format("Converting from %s to %s...", sourceClassName, targetClassName));
                targetObject = conversionService.convert(sourceObject, targetType);
                LOGGER.debug(String.format("Converted from %s to %s.", sourceClassName, targetClassName));
            } catch (ConversionFailedException e) {
                Throwable rootCause = e.getRootCause();
                throw new MRInternalException(String.format("Conversion from %s to %s failed!", sourceClassName, targetClassName), rootCause);
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
