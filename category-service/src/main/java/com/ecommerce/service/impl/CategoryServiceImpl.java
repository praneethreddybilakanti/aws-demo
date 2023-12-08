package com.ecommerce.service.impl;

import com.ecommerce.dao.CategoryRepository;
import com.ecommerce.entity.category.Category;
import com.ecommerce.service.CategoryService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category save(Category entity) {
        if (entity.getParent() != null) {
            final Optional<Category> parentCategory = categoryRepository.findById(entity.getParent().getId());
            entity.setParent(parentCategory.isPresent() ? parentCategory.get() : null);

        }

        return categoryRepository.save(entity);
    }

    @Override
    public List<Category> save(List<Category> entities) {

        return null;
    }

    @Override
    public void deleteById(Integer id) {
        Category category = findById(id);
        if (ObjectUtils.isNotEmpty(category)) {
            categoryRepository.deleteById(id);
        }
    }


    @Override
    public Category findById(Integer id) {

        final Optional<Category> category = categoryRepository.findById(id);
        return  category.orElseGet(category::orElseThrow);
         }

    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Category update(Category entity, Integer id) {
        Category category = findById(id);
        if (ObjectUtils.isNotEmpty(category)) {
            return categoryRepository.save(asUpdateEntity(entity, category));
        }
        return null;
    }



    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findByParentNull();
    }
    private  Category asUpdateEntity(Category entity, Category category) {
        category.setName(entity.getName());
        category.setEnabled(entity.isEnabled());
        category.setSlung(entity.getSlung());
        category.setDescription(entity.getDescription());
        return category;
    }
}
