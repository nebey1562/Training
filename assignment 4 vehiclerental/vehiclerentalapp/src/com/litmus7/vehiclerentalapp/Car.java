package com.litmus7.vehiclerentalapp;

import java.util.Scanner;

import com.litmus7.vehiclerentalapp.Vehicle;

/**
 * Represents a car, which is a type of Vehicle, with specific attributes like
 * number of doors and transmission type.
 * <p>
 * Extends the functionality of the Vehicle class.
 * </p>
 * 
 * @author Eben
 * @version Java 19
 */
public class Car extends Vehicle {

	private int numberOfDoors;
	private boolean isAutomatic;

	/**
	 * Default constructor initializing car-specific fields.
	 */
	public Car() {
		super();
		numberOfDoors = 0;
		isAutomatic = false;
	}

	/**
	 * Parameterized constructor to initialize car with specific attributes.
	 *
	 * @param brand             the brand of the car
	 * @param model             the model of the car
	 * @param rentalPricePerDay the rental cost per day
	 * @param numberOfDoors     number of doors in the car
	 * @param isAutomatic       whether the car is automatic or manual
	 */
	public Car(String brand, String model, double rentalPricePerDay, int numberOfDoors, boolean isAutomatic) {
		super(brand, model, rentalPricePerDay);
		this.numberOfDoors = numberOfDoors;
		this.isAutomatic = isAutomatic;
	}

	/**
	 * Accepts user input to populate car-specific details along with base vehicle
	 * info.
	 */
	@Override
	public void inputDetails() {
		super.inputDetails();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of doors:");
		numberOfDoors = scanner.nextInt();
		System.out.println("Is it automatic (true/false)?");
		isAutomatic = scanner.nextBoolean();
	}

	/**
	 * Displays the car-specific details along with base vehicle info.
	 */
	@Override
	public void displayDetails() {
		super.displayDetails();
		System.out.println("Number of Doors: " + numberOfDoors);
		System.out.println("Automatic: " + isAutomatic + "\n");
	}
}
