package com.food.service;

import java.time.LocalDate;
import java.util.List;

import com.food.exception.BillException;
import com.food.model.Bill;

public interface BillService 
{
	public Bill addBill(Bill bill)throws BillException;
	
	public Bill updateBill(Bill bill)throws BillException;
	
	public Bill removeBill(Integer id)throws BillException;
	
	public Bill viewBill(Integer id)throws BillException;
	
	public List<Bill> viewAllBills(LocalDate startDate, LocalDate endDate) throws BillException;
	
	public double CalculateTotalCost(Integer id)throws BillException;
	
	

}

