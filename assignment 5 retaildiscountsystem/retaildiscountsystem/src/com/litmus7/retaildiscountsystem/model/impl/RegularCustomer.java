package com.litmus7.retaildiscountsystem.model.impl;

import com.litmus7.retaildiscountsystem.model.Discountable;

/**
 * Represents a Regular customer in the Retail Discount System.
 * <p>
 * Regular customers receive a flat 5% discount on their total purchase amount.
 * </p>
 * 
 * Author: Eben
 */
public class RegularCustomer implements Discountable {

	/**
	 * Applies a flat 5% discount to the total purchase amount for a Regular
	 * customer.
	 * 
	 * @param totalAmount The total purchase amount
	 * @return The amount after applying the discount
	 */
	@Override
	public double applyDiscount(double totalAmount) {
		return (totalAmount - (totalAmount * 0.05));
	}
}
