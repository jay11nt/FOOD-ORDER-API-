package com.food.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.exception.BillException;
import com.food.model.Bill;
import com.food.repository.BillRepo;
import com.food.service.BillService;

@Service
public class BillServiceImpl implements BillService
{
	@Autowired
	private BillRepo billRepo;

	@Override
	public Bill addBill(Bill bill) throws BillException 
	{
		if(bill == null)
		{
			throw new BillException("Please Enter Valid Input");
		}
		 Bill save = billRepo.save(bill);
		 return save;
	}

	@Override
	public Bill updateBill(Bill bill) throws BillException 
	{
		billRepo.findById(bill.getBillId()).orElseThrow(()-> new BillException("Bill details not found..."));
		
		Bill save = billRepo.save(bill);
		return save;
	}

	@Override
	public Bill removeBill(Integer id) throws BillException 
	{
		Bill bill = billRepo.findById(id)
				.orElseThrow(()-> new BillException("Bill Details not Found..."));
		
		billRepo.delete(bill);
		
		return bill;
	}

	@Override
	public Bill viewBill(Integer id) throws BillException 
	{
		Bill bill = billRepo.findById(id).orElseThrow(()-> new BillException("Bill Details not Found..."));
		
		return bill;
	}

	@Override
	public List<Bill> viewAllBills(LocalDate startDate, LocalDate endDate) throws BillException 
	{
		List<Bill> list = billRepo.getBillByDate(startDate, endDate);
		if(list.size()==0)
		{
			throw new BillException("Bill details not found between" + startDate + "and" + endDate);
		}
		return list;
	}

	@Override
	public double CalculateTotalCost(Integer id) throws BillException {
		Bill bill = billRepo.findById(id).orElseThrow(()-> new BillException("Bill details not found..."));
		
		return bill.getTotalCost();
	}

}

