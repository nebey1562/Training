package com.litmus7.userregisterationsystem.ui;

import java.util.Scanner;

import com.litmus7.userregisterationsystem.controller.UserRegistrationController;
import com.litmus7.userregisterationsystem.dto.Response;
import com.litmus7.userregisterationsystem.dto.User;

public class UserRegistrationApp {

	public static void main(String[] args) {

		UserRegistrationController userRegistrationController = new UserRegistrationController();
		Response<User> registrationResponse = new Response<>();

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter username: ");
		String username = scanner.nextLine();

		System.out.print("Enter age: ");
		int age = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Enter email: ");
		String email = scanner.nextLine();

		System.out.print("Enter password: ");
		String password = scanner.nextLine();

		registrationResponse = userRegistrationController.registerUser(username, age, email, password);
		if (registrationResponse.getStatusCode() == 200) {
			System.out.println(registrationResponse.getData());
		} else {
			System.out.println(registrationResponse.getErrorMessage());
		}

		scanner.close();
	}

}
