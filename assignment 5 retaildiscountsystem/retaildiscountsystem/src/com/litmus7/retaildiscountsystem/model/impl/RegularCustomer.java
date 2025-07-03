package com.litmus7.retaildiscountsystem.model.impl;

import com.litmus7.retaildiscountsystem.model.Discountable;

public class RegularCustomer implements Discountable {

	@Override
	public double applyDiscount(double totalAmount) {
		return (totalAmount-(totalAmount*0.05));
	}

}
