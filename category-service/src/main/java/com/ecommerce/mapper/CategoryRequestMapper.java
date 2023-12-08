package com.ecommerce.mapper;

import com.ecommerce.entity.category.Category;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface CategoryRequestMapper extends GenericRequestMapper<Category,String> {
    Category asEntityWithString(String dto) throws JsonProcessingException;

}
