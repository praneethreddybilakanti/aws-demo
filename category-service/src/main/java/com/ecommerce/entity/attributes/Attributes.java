package com.ecommerce.entity.attributes;

import com.ecommerce.entity.IdBasedEntity;
import com.ecommerce.entity.category.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Attributes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Attributes extends IdBasedEntity {
    private String attributeKey;
    private String displayName;
    private String attributeValue;
    private Boolean is_search_filter;
    public Boolean is_display_attributes;
    private Boolean is_variant;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "attributes_categories",
            joinColumns = @JoinColumn(name = "attributes_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
  private Set<Category> categories = new HashSet<>();
}