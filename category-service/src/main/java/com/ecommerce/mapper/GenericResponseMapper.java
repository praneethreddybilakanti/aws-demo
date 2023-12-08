package com.ecommerce.mapper;

import java.util.List;

public interface GenericResponseMapper<E,D>{

    D asDTO(E entity);



    List<D> asDTOList(List<E> entityList);
}
