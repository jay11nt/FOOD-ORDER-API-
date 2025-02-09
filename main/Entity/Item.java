package com.food.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
public class Item 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer itemId;
    private String itemName;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Category category;
    
    private Integer quantity;
    
    private double cost;
    
   // @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "itemList")
    private List<Restaurant> restaurant = new ArrayList<>();

}

