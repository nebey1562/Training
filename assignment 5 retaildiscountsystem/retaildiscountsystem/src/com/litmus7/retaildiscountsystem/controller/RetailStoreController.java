package com.litmus7.retaildiscountsystem.controller;

import com.litmus7.retaildiscountsystem.dto.Response;
import com.litmus7.retaildiscountsystem.service.RetailStoreService;

/**
 * Controller class for handling discount-related requests in the Retail
 * Discount System.
 * <p>
 * This class acts as an intermediary between the UI layer and the service
 * layer, validating inputs and constructing response objects.
 * </p>
 * 
 * Author: Eben
 */
public class RetailStoreController {

	/** Success status code constant */
	public static final int SUCCESS_CODE = 200;

	/** Error status code constant */
	public static final int ERROR_CODE = 400;

	RetailStoreService reatailStoreService = new RetailStoreService();

	/**
	 * Finds the discount details for the given customer type and purchase amount.
	 * <p>
	 * Validates the input and invokes the service layer to calculate discounts.
	 * Returns a Response object containing discount details or an error message.
	 * </p>
	 * 
	 * @param customerType The type of customer (1-Regular, 2-Premium, 3-Wholesale)
	 * @param totalAmount  The total purchase amount
	 * @return A Response object containing discount details or an error message
	 */
	public Response<String> findDiscountDetails(int customerType, double totalAmount) {
		Response<String> discountResponse = new Response<>();

		if (totalAmount > 0) {
			discountResponse.setData(reatailStoreService.findDiscountDetails(customerType, totalAmount));
			discountResponse.setStatusCode(SUCCESS_CODE);
		} else {
			discountResponse.setStatusCode(ERROR_CODE);
			discountResponse.setErrorMessage("Purchase amount should be greater than 0");
		}

		return discountResponse;
	}
}
