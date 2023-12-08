package com.ecommerce.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryRequestDTO {
    private String name;
    private String alias;
private Set<CategoryRequestDTO> subCategories;
}
