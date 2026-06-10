package com.farmermarket.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductRequest {

	private String productName;

	private String description;

	private BigDecimal price;

	private Integer quantity;

	private String unit;

	private Long categoryId;

	private Boolean organic;

	private LocalDate harvestDate;

	private LocalDate expiryDate;
}