package com.litmus7.retaildiscountsystem.model.impl;

import com.litmus7.retaildiscountsystem.model.Discountable;

/**
 * Represents a Premium customer in the Retail Discount System.
 * <p>
 * Premium customers receive a 10% discount on purchases of ₹5,000 or more, and
 * a 7% discount otherwise.
 * </p>
 * 
 * Author: Eben
 */
public class PremiumCustomer implements Discountable {

	/**
	 * Applies the discount for a Premium customer based on the total purchase
	 * amount.
	 * 
	 * @param totalAmount The total purchase amount
	 * @return The amount after applying the applicable discount
	 */
	@Override
	public double applyDiscount(double totalAmount) {
		return totalAmount >= 5000 ? (totalAmount - (totalAmount * 0.1)) : (totalAmount - (totalAmount * 0.07));
	}
}
