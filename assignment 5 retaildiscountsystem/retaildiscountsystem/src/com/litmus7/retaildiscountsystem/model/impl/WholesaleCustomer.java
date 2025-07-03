package com.litmus7.retaildiscountsystem.model.impl;

import com.litmus7.retaildiscountsystem.model.Discountable;

public class WholesaleCustomer implements Discountable {

	@Override
	public double applyDiscount(double totalAmount) {
		return totalAmount >= 10000 ? (totalAmount - (totalAmount * 0.15)) : (totalAmount - (totalAmount * 0.1));
	}

}
