package com.litmus7.retaildiscountsystem.service;

import com.litmus7.retaildiscountsystem.model.Discountable;
import com.litmus7.retaildiscountsystem.model.impl.PremiumCustomer;
import com.litmus7.retaildiscountsystem.model.impl.RegularCustomer;
import com.litmus7.retaildiscountsystem.model.impl.WholesaleCustomer;

/**
 * Service class for handling discount-related operations in the Retail Discount
 * System.
 * <p>
 * This class determines the customer type, applies the relevant discount, and
 * generates the billing details.
 * </p>
 * 
 * Author: Eben
 */
public class RetailStoreService {

	/**
	 * Calculates discount details based on customer type and purchase amount.
	 * 
	 * @param customerType The type of customer (1-Regular, 2-Premium, 3-Wholesale)
	 * @param totalAmount  The total purchase amount
	 * @return A formatted string containing customer type, original amount,
	 *         discount applied, and final payable amount
	 */
	public String findDiscountDetails(int customerType, double totalAmount) {
		String customerString = null;
		Discountable customer = null;

		switch (customerType) {
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
			break;
		}

		double discountedAmount = customer.applyDiscount(totalAmount);

		return "Bill\nCustomer Type :" + customerString + "\nOriginal Amount :" + totalAmount + "\nDiscount Applied :"
				+ (totalAmount - discountedAmount) + "\nFinal Payable Amount :" + discountedAmount;
	}
}
