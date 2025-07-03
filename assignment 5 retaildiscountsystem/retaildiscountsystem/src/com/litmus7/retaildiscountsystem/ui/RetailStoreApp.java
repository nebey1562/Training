package com.litmus7.retaildiscountsystem.ui;

import java.util.Scanner;

import com.litmus7.retaildiscountsystem.controller.RetailStoreController;
import com.litmus7.retaildiscountsystem.dto.Response;

public class RetailStoreApp {

	public static void main(String[] args) {
		
		RetailStoreController controller = new RetailStoreController();

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter Customer Type (1-Regular, 2-Premium, 3-Wholesale) :");
		int customerType = scanner.nextInt();
		System.out.println("Enter Total Purchase Amount");
		double totalAmount = scanner.nextDouble();
		
		Response<String> response = new Response();
		response = controller.findDiscountDetails(customerType, totalAmount);
		if (response.getStatusCode() == 200)
				System.out.println(response.getData());
		else
			System.out.println(response.getErrorMessage());
		
		scanner.close();
		
	}

}
