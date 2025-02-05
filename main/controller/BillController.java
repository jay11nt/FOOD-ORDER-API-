package com.food.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.food.exception.BillException;
import com.food.model.Bill;
import com.food.service.BillService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class BillController 
{

	@Autowired
	private BillService billService;
	
	@PostMapping("/addBill")
	public ResponseEntity<Bill> addBill(@RequestBody Bill bill)throws BillException
	{

		Bill bill2 = billService.addBill(bill);
		return new ResponseEntity<Bill>(bill2,HttpStatus.CREATED);

	}
	
	@PutMapping("/updateBill")
	public ResponseEntity<Bill>updateBill(@RequestBody Bill bill)throws BillException
	{

		Bill updateBill = billService.updateBill(bill);
		return new ResponseEntity<Bill>(updateBill,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteBill/{id}")
	public ResponseEntity<Bill>removeBill(@PathVariable ("id")Integer id)throws BillException
	{
		Bill removeBill = billService.removeBill(id);
		return new ResponseEntity<Bill>(removeBill,HttpStatus.OK);
	}
	
	@GetMapping("/viewBill/{id}")
	public ResponseEntity<Bill> viewBill(@PathVariable ("id") Integer id)throws BillException
	{
		Bill viewBill = billService.viewBill(id);
		return new ResponseEntity<Bill>(viewBill,HttpStatus.FOUND);
	}
	
	@GetMapping("/viewAllBills")
	public ResponseEntity<List<Bill>>viewAllBills(@RequestParam String startDate,@RequestParam String endDate)throws BillException
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-mm-yyyy");
		LocalDate start = LocalDate.parse(startDate, dtf);
		LocalDate end = LocalDate.parse(endDate, dtf);
		
		
		List<Bill> viewAllBills = billService.viewAllBills(start,end);
		return new ResponseEntity<List<Bill>>(viewAllBills,HttpStatus.FOUND);
	}
	
	@GetMapping("/getTotalCost/{id}")
	public ResponseEntity<Double>CalculateTotalCost(@PathVariable ("id") Integer id)throws BillException
	{
		double totalCost = billService.CalculateTotalCost(id);
		return new ResponseEntity<Double>(totalCost,HttpStatus.OK);
	}
	
}

