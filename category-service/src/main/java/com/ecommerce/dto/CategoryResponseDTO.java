package com.ecommerce.dto;

import com.ecommerce.entity.IdBasedEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CategoryResponseDTO extends IdBasedEntity {
    private String name;
    private String alias;
    private String image;

    private boolean enabled;
private CategoryResponseDTO subCategories;
private List<String> assets;
}
