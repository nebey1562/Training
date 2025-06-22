package com.litmus7.vehiclerental;

import java.util.Scanner;

/**
 * Represents a generic vehicle with basic attributes such as brand, model, and
 * rental price per day.
 * <p>
 * This class serves as a superclass for more specific vehicle types like Car
 * and Bike.
 * </p>
 * 
 * @author Eben
 * @version Java 19
 */
public class Vehicle {
	private String brand;
	private String model;
	private double rentalPricePerDay;

	/**
	 * Default constructor initializing fields with default values.
	 */
	public Vehicle() {
		brand = "Default";
		model = "Default";
		rentalPricePerDay = 0.0;
	}

	/**
	 * Parameterized constructor to initialize a vehicle with specific details.
	 *
	 * @param brand             the brand of the vehicle
	 * @param model             the model of the vehicle
	 * @param rentalPricePerDay the rental cost per day
	 */
	public Vehicle(String brand, String model, double rentalPricePerDay) {
		this.brand = brand;
		this.model = model;
		this.rentalPricePerDay = rentalPricePerDay;
	}

	/**
	 * Accepts user input to populate vehicle details. Note: Does not close the
	 * scanner to avoid input stream closure.
	 */
	public void inputDetails() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter brand:");
		brand = scanner.nextLine();
		System.out.println("Enter model:");
		model = scanner.nextLine();
		System.out.println("Enter rental price per day:");
		rentalPricePerDay = scanner.nextDouble();
	}

	/**
	 * Displays the details of the vehicle.
	 */
	public void displayDetails() {
		System.out.println("Brand: " + brand);
		System.out.println("Model: " + model);
		System.out.println("Rental Price per Day: " + rentalPricePerDay);
	}
}
