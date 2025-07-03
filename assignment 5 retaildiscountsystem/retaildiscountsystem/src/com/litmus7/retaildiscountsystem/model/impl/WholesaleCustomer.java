package com.litmus7.retaildiscountsystem.model.impl;

import com.litmus7.retaildiscountsystem.model.Discountable;

/**
 * Represents a Wholesale customer in the Retail Discount System.
 * <p>
 * Wholesale customers receive a 15% discount on purchases of ₹10,000 or more,
 * and a 10% discount otherwise.
 * </p>
 * 
 * Author: Eben
 */
public class WholesaleCustomer implements Discountable {

	/**
	 * Applies the discount for a Wholesale customer based on the total purchase
	 * amount.
	 * 
	 * @param totalAmount The total purchase amount
	 * @return The amount after applying the applicable discount
	 */
	@Override
	public double applyDiscount(double totalAmount) {
		return totalAmount >= 10000 ? (totalAmount - (totalAmount * 0.15)) : (totalAmount - (totalAmount * 0.1));
	}
}
