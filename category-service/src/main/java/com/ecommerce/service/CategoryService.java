package com.ecommerce.service;

import com.ecommerce.entity.category.Category;

import java.util.List;

public interface CategoryService extends GenericService<Category,Integer> {

    List<Category> findAllCategories();
}
