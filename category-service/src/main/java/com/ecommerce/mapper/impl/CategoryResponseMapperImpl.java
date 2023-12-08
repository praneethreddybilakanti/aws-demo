package com.ecommerce.mapper.impl;

import com.ecommerce.dto.CategoryResponseDTO;
import com.ecommerce.entity.category.Category;
import com.ecommerce.mapper.CategoryResponseMapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CategoryResponseMapperImpl implements CategoryResponseMapper {
    @Override
    public CategoryResponseDTO asDTO(Category entity) {

            return  null;

    }

    @Override
    public List<CategoryResponseDTO> asDTOList(List<Category> entityList) {
        return null;
    }
}
