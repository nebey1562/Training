package com.litmus7.retaildiscountsystem.controller;

import com.litmus7.retaildiscountsystem.dto.Response;
import com.litmus7.retaildiscountsystem.service.RetailStoreService;

public class RetailStoreController {

	public static final int SUCCESS_CODE =200;
	
	public static final int ERROR_CODE =400;
	
	RetailStoreService service = new RetailStoreService();
	
	public Response<String> findDiscountDetails(int customerType, double totalAmount){
		Response<String> response = new Response();
		if (totalAmount >0) {
			response.setData(service.findDiscountDetails(customerType, totalAmount));
			response.setStatusCode(SUCCESS_CODE);
		}
		else {
			response.setStatusCode(ERROR_CODE);
			response.setErrorMessage("Purcahse amount should be grater then 0");
		}
		return response;
	}
	
}
