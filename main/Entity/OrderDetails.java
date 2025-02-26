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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;

    private LocalDate orderDate;

    private String orderStatus;
    
    @OneToOne( cascade = CascadeType.ALL)
    private FoodCart foodCart;

}

