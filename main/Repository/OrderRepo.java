package com.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.model.OrderDetails;

@Repository
public interface OrderRepo extends JpaRepository<OrderDetails, Integer>{

}

