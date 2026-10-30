package com.example.cardmanagment.util;

import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class MapperUtil {

    @Named("mapEntitiesToIds")
    public Set<UUID> mapEntitiesToIds(Set<?> entities) {
        if (entities == null) {
            return Collections.emptySet();
        }
        return entities.stream()
                .map(entity -> {
                    try {
                        Method getIdMethod = entity.getClass().getMethod("getId");
                        return (UUID) getIdMethod.invoke(entity);
                    } catch (Exception e) {
                        throw new IllegalArgumentException("Сущность не содержит метода getId", e);
                    }
                }).collect(Collectors.toSet());
    }
}
