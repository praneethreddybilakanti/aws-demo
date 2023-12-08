package com.ecommerce.entity.manufacture;

import com.ecommerce.entity.IdBasedEntity;
import com.ecommerce.entity.product.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ManufacturerDescription  extends IdBasedEntity {
    public String type;
    public String title;
    public String description;
    public String imagePath;
    public String fileName;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}