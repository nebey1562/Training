package com.litmus7.retaildiscountsystem.service;

import com.litmus7.retaildiscountsystem.model.Discountable;
import com.litmus7.retaildiscountsystem.model.impl.PremiumCustomer;
import com.litmus7.retaildiscountsystem.model.impl.RegularCustomer;
import com.litmus7.retaildiscountsystem.model.impl.WholesaleCustomer;

public class RetailStoreService {
	
	public String findDiscountDetails(int customerType, double totalAmount) {
		String customerString = null;
		Discountable customer = null;
		switch(customerType) {
		case 1:
			customer = new RegularCustomer();
			customerString = "RegularCustomer";
			break;
		case 2:
			customer = new PremiumCustomer();
			customerString = "PremiumCustomer";
			break;
		case 3:
			customer = new WholesaleCustomer();
			customerString = "WholesaleCustomer";
			break;
		default:
			System.out.println("Invalid Customer");
			
		}
		double discountedAmount=customer.applyDiscount(totalAmount);
		return "Bill\nCustomer Type :" + customerString +"\nOriginal Amount :" + totalAmount + "\nDiscount Applied :" + (totalAmount - discountedAmount) + "\nFinal Payable Amount :" + discountedAmount;
	}

}
