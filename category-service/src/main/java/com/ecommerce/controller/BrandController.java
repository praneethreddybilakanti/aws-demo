package com.ecommerce.controller;

import com.ecommerce.dao.BrandRepository;
import com.ecommerce.entity.brand.Brand;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/brands")
public class BrandController {
    private final BrandRepository brandRepository;

    public BrandController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }
    @PostMapping
    public Brand createBrand(@RequestBody Brand brand){
        return brandRepository.save(brand);
    }
}
