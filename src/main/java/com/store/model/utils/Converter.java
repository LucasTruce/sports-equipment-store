package com.store.model.utils;

import java.util.List;
import java.util.stream.Collectors;

public interface Converter<T, S> {

    S entityToDto(T source);
    T dtoToEntity(S destination);

    default List<S> convertAllToDto(List<T> entityObjects){
        return entityObjects.stream()
                        .map(this::entityToDto)
                        .collect(Collectors.toList());
    }
}
