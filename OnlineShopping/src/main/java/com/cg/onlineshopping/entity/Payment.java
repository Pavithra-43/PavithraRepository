package com.cg.onlineshopping.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Payment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Attributes of Payment
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long paymentId; 
	private String paymentType;
	private String paymentStatus;
	
	@OneToOne(mappedBy = "payment")
	@JsonIgnore
	private OrderDetails orderDetails;

	public Payment(String paymentType, String paymentStatus, OrderDetails orderDetails) {
		super();
		this.paymentType = paymentType;
		this.paymentStatus = paymentStatus;
		this.orderDetails = orderDetails;
	}

}
