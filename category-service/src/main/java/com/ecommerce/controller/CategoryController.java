package com.ecommerce.controller;

import com.ecommerce.dao.CategoryRepository;
import com.ecommerce.entity.category.Category;
import com.ecommerce.mapper.CategoryRequestMapper;
import com.ecommerce.mapper.CategoryResponseMapper;
import com.ecommerce.service.CategoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@Slf4j
public class CategoryController {
    private final CategoryRepository categoryRepository;
    private final CategoryRequestMapper categoryRequestMapper;
    private final CategoryResponseMapper categoryResponseMapper;
    private final CategoryService categoryService;

    public CategoryController(CategoryRepository categoryRepository, CategoryRequestMapper categoryRequestMapper, CategoryResponseMapper categoryResponseMapper, CategoryService categoryService) {
        this.categoryRepository = categoryRepository;
        this.categoryRequestMapper = categoryRequestMapper;
        this.categoryResponseMapper = categoryResponseMapper;
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody String dto) throws JsonProcessingException {

        return new ResponseEntity((categoryService.save(categoryRequestMapper.asEntityWithString(dto))),HttpStatus.CREATED);


    }

    @GetMapping
    public ResponseEntity<List<Category>> findAllCategories() {
        return ResponseEntity.ok(categoryService.findAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(categoryService.findById(id),HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
public  ResponseEntity<Category> updateCategory(@RequestBody String dto,@PathVariable Integer id ) throws JsonProcessingException {

    return  new  ResponseEntity(categoryService.update(categoryRequestMapper.asEntityWithString(dto),id),HttpStatus.OK);
}

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        categoryService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
