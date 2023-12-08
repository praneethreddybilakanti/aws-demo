package com.ecommerce.mapper.impl;

import com.ecommerce.entity.category.Category;
import com.ecommerce.mapper.CategoryRequestMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CategoryRequestMapperImpl implements CategoryRequestMapper {


    @Override
    public Category asEntity(String dto) {

        return null;
    }

    @Override
    public List<Category> asEntityList(List<String> dtoList) {
        return null;
    }

    @Override
    public Category asEntityWithString(String dto) throws JsonProcessingException {
        ObjectMapper objMapper = new ObjectMapper();
       return objMapper.convertValue(objMapper.readValue(dto, ObjectNode.class), Category.class);

    }
}
