package com.litmus7.retaildiscountsystem.model.impl;

import com.litmus7.retaildiscountsystem.model.Discountable;

public class PremiumCustomer implements Discountable {

	@Override
	public double applyDiscount(double totalAmount) {
		return totalAmount >= 5000 ? (totalAmount - (totalAmount * 0.1)) : (totalAmount - (totalAmount * 0.07));
	}

}
