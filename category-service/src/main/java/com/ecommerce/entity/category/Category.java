package com.ecommerce.entity.category;

import com.ecommerce.entity.IdBasedEntity;
import com.ecommerce.utils.StringSpaceTrimmer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@ToString(callSuper = true)
public class Category extends IdBasedEntity {
    @Column(length = 128, nullable = false, unique = true)
    @JsonDeserialize(converter = StringSpaceTrimmer.class)

    private String name;

    @JsonDeserialize(converter = StringSpaceTrimmer.class)
    @Column(length = 64, nullable = false, unique = true)
    private String slung;
    @Column(length = 64, nullable = false, unique = true)
    private String description;
    private boolean enabled;

    @JsonBackReference
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "parentCategory")
    private Category parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private Set<Category> subCategories = new HashSet<>();
 private List<String> assets = new ArrayList<>();


}
