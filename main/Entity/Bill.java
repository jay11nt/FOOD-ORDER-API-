package com.food.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Bill 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer billId;
	
	private LocalDate billDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	private OrderDetails orderDetails;
	
	private Integer totalItem;
	
	private Double totalCost;

}

