package com.litmus7.retaildiscountsystem.model;

/**
 * Represents the contract for applying discounts to a purchase amount.
 * <p>
 * Any customer type (Regular, Premium, Wholesale, etc.) implementing this
 * interface must provide the logic for applying relevant discounts.
 * </p>
 * 
 * Author: Eben
 */
public interface Discountable {

	/**
	 * Applies the appropriate discount to the total purchase amount.
	 * 
	 * @param totalAmount The total purchase amount
	 * @return The amount after applying the discount
	 */
	double applyDiscount(double totalAmount);
}
