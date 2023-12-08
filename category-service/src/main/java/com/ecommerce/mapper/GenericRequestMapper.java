package com.ecommerce.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface GenericRequestMapper <E,D>{
    E asEntity(D dto) ;



    List<E> asEntityList(List<D> dtoList);
}
