package com.ecommerce.controller;

import com.ecommerce.dao.AttributesRepository;
import com.ecommerce.entity.attributes.Attributes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/attributes")
public class AttributesController {
    private final AttributesRepository attributesRepository;

    public AttributesController(AttributesRepository attributesRepository) {
        this.attributesRepository = attributesRepository;
    }
    @PostMapping
    public Attributes createAttributes(@RequestBody Attributes attributes){
        return attributesRepository.save(attributes);
    }
}
