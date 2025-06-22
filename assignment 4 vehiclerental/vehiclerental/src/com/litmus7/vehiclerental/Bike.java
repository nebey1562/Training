package com.litmus7.vehiclerental;

import java.util.Scanner;

/**
 * Represents a bike, which is a type of Vehicle, with specific attributes like
 * engine capacity and electric status.
 * <p>
 * Extends the functionality of the Vehicle class.
 * </p>
 * 
 * @author Eben
 * @version Java 19
 */
public class Bike extends Vehicle {

	private boolean isElectric;
	private int engineCapacity;

	/**
	 * Default constructor initializing bike-specific fields.
	 */
	public Bike() {
		super();
		isElectric = false;
		engineCapacity = 0;
	}

	/**
	 * Parameterized constructor to initialize bike with specific attributes.
	 *
	 * @param brand             the brand of the bike
	 * @param model             the model of the bike
	 * @param rentalPricePerDay the rental cost per day
	 * @param isElectric        whether the bike is electric
	 * @param engineCapacity    engine capacity in cc
	 */
	public Bike(String brand, String model, double rentalPricePerDay, boolean isElectric, int engineCapacity) {
		super(brand, model, rentalPricePerDay);
		this.isElectric = isElectric;
		this.engineCapacity = engineCapacity;
	}

	/**
	 * Accepts user input to populate bike-specific details along with base vehicle
	 * info.
	 */
	@Override
	public void inputDetails() {
		super.inputDetails();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Is it electric (true/false)?");
		isElectric = scanner.nextBoolean();
		System.out.println("Enter engine capacity in cc:");
		engineCapacity = scanner.nextInt();
	}

	/**
	 * Displays the bike-specific details along with base vehicle info.
	 */
	@Override
	public void displayDetails() {
		super.displayDetails();
		System.out.println("Electric: " + isElectric);
		System.out.println("Engine Capacity (cc): " + engineCapacity);
	}
}
