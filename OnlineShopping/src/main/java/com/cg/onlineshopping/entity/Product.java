package com.cg.onlineshopping.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * @author PAVITHRA
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Attributes of Product
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long productId;
	private String productName;
	private String productCategory;
	private String productBrand;
	private Double unitPrice;
	private String description;
	private String availability;
	/**
	 * 
	 * @param productName
	 * @param productCategory
	 * @param productBrand
	 * @param unitPrice
	 * @param description
	 * @param availability
	 */
	public Product(String productName, String productCategory, String productBrand, Double unitPrice,
			String description, String availability) {
		super();
		this.productName = productName;
		this.productCategory = productCategory;
		this.productBrand = productBrand;
		this.unitPrice = unitPrice;
		this.description = description;
		this.availability = availability;
	}
	
	


}
