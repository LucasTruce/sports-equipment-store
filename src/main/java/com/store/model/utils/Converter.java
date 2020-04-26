package com.store.model.utils;

import org.modelmapper.ModelMapper;

public interface Converter<T, S> {

    default S entityToDto(T source, Class<S> dtoClass){
        return new ModelMapper().map(source, dtoClass);
    }

    default T dtoToEntity(S source, Class<T> entityClass){
        return new ModelMapper().map(source, entityClass);
    }

}
