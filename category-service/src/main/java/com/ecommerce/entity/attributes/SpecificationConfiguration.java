package com.ecommerce.entity.attributes;

import com.ecommerce.entity.IdBasedEntity;
import com.ecommerce.entity.category.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "specification_configurations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpecificationConfiguration extends IdBasedEntity {
    private String specificationName;
    private String specificationValue;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Category category;
}