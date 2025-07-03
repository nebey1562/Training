package com.litmus7.retaildiscountsystem.ui;

import java.util.Scanner;

import com.litmus7.retaildiscountsystem.controller.RetailStoreController;
import com.litmus7.retaildiscountsystem.dto.Response;

/**
 * Entry point for the Retail Discount System application.
 * <p>
 * This class provides a console-based interface for the user to input customer
 * type and purchase amount, and displays the discount details based on the
 * input.
 * </p>
 * 
 * Author: Eben
 */
public class RetailStoreApp {

	/**
	 * Main method to run the Retail Discount System application.
	 * <p>
	 * Prompts the user to enter the customer type and total purchase amount. Calls
	 * the controller to calculate and display applicable discounts.
	 * </p>
	 * 
	 * @param args Command-line arguments (not used)
	 */
	public static void main(String[] args) {

		RetailStoreController controller = new RetailStoreController();
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter Customer Type (1-Regular, 2-Premium, 3-Wholesale) :");
		int customerType = scanner.nextInt();

		System.out.println("Enter Total Purchase Amount");
		double totalAmount = scanner.nextDouble();

		Response<String> response = controller.findDiscountDetails(customerType, totalAmount);

		if (response.getStatusCode() == 200)
			System.out.println(response.getData());
		else
			System.out.println(response.getErrorMessage());

		scanner.close();
	}
}
