package com.ecommerce.entity.product;

import com.ecommerce.entity.IdBasedEntity;
import com.ecommerce.entity.brand.Brand;
import com.ecommerce.entity.category.Category;

import com.ecommerce.entity.manufacture.ManufacturerDescription;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product extends IdBasedEntity {
	
	@Column(unique = true, length = 255, nullable = false)
	private String name;
	
	@Column(unique = true, length = 255, nullable = false)
	private String alias;
	
	@Column(length = 512, nullable = false, name = "short_description")
	private String shortDescription;
	
	@Column(length = 4096, nullable = false, name = "full_description")
	private String fullDescription;


	
	private boolean enabled;
	
	@Column(name = "in_stock")
	private boolean inStock;
	
	private float cost;
	
	private float price;
	
	@Column(name = "discount_percent")
	private float discountPercent;
	
	private float length;
	private float width;
	private float height;
	private float weight;
	
	@Column(name = "main_image", nullable = false)
	private String mainImage;
		
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "brand_id")	
	private Brand brand;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)

	private List<ManufacturerDescription> manufacturerDescription;

	private Set<String> images = new HashSet<>();
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProductDetail> details = new ArrayList<>();

	private int reviewCount;
	private float averageRating;
	
	@Transient private boolean customerCanReview;
	@Transient private boolean reviewedByCustomer;
	
	public Product(Integer id) {
		this.id = id;
	}








	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + "]";
	}






	


	




	
}
