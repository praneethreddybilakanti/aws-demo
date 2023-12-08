package com.ecommerce.dao;

import com.ecommerce.entity.attributes.Attributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributesRepository extends JpaRepository<Attributes, Integer> {
}