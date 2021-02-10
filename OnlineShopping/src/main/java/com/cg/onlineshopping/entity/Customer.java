package com.cg.onlineshopping.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Attributes of Customer
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long customerId;
	@Column(unique = true)
	private String username;
	private String password;
	private String customerName;
	private String gender;
	@Column(unique = true)
	private String mobile;
	@Column(unique = true)
	private String email;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Address address;
	
	@JoinColumn(name = "cart_line_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private CartLine cartLine;
	
	@JoinColumn(name = "wish_list_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private WishList wishList;
	

}
