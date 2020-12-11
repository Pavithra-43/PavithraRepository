package com.cg.onlineshopping.entity;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
public class OrderDetails implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Attributes of Order
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long orderId;
	private double totalAmount;
	private String orderDate;
	private String expectedDeliveryDate;
	private String orderStatus; 
	
	@JoinColumn(name = "payment_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Payment payment;
	
	

	

}
