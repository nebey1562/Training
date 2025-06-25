package com.litmus7.vehiclerentalapp;

import com.litmus7.vehiclerentalapp.Bike;
import com.litmus7.vehiclerentalapp.Car;
import com.litmus7.vehiclerentalapp.VehicleService;

/**
 * The {@code VehicleApp} class is the entry point for the Vehicle Rental
 * application. It demonstrates how to input and display details of vehicles
 * like Car and Bike.
 * <p>
 * It includes both default constructor usage (user input) and parameterized
 * constructors for showcasing vehicle details.
 * </p>
 *
 * @author Eben
 * @version Java 19
 */
public class VehicleApp {

	/**
	 * The main method that drives the Vehicle Rental application. It creates
	 * instances of Car and Bike using both default and parameterized constructors,
	 * and displays their details.
	 *
	 * @param args Command-line arguments (not used in this application)
	 */
	public static void main(String[] args) {
		VehicleService vehicleService = new VehicleService();

//		Car car = new Car();
//		System.out.println("--- Enter Car Details ---");
//		car.inputDetails();
//		System.out.println("--- Displaying Car Details ---");
//		car.displayDetails();
//
//		System.out.println();
//
//		Bike bike = new Bike();
//		System.out.println("--- Enter Bike Details ---");
//		bike.inputDetails();
//		System.out.println("--- Displaying Bike Details ---");
//		bike.displayDetails();
//
//		System.out.println();
//
//		Car carParametrerized = new Car("Ferrari", "LaFerrari", 140000.0, 4, false);
//		System.out.println("--- Displaying Car Details (Parameterized) ---");
//		carParametrerized.displayDetails();
//
//		System.out.println();
//
//		Bike bikeParametrerized = new Bike("Triumph", "Scrambler 400x", 6000.0, false, 400);
//		System.out.println("--- Displaying Bike Details (Parameterized) ---");
//		bikeParametrerized.displayDetails();

		System.out.println("Loading all data from text file");
		vehicleService.loadDataFromFile("src/com/litmus7/vehiclerentalapp/vehicles.txt");

		System.out.println("\nUpdated Details are\n");
		vehicleService.displayAvailableVehicles();
		
		System.out.println("\nTotal rent for all the vehicles are:" + vehicleService.calculateTotalRent() +"\n");

		// via default constructor
		Car car = new Car();
		System.out.println("--- Enter Car Details ---");
		car.inputDetails();
		// via parameterized constructor
		Car carParametrerized = new Car("Ferrari", "LaFerrari", 140000.0, 4, false);
		vehicleService.addVehicle(carParametrerized);

		System.out.println("\nUpdated Details are\n");
		vehicleService.displayAvailableVehicles();
		
		System.out.println("\nTotal rent for all the vehicles are:" + vehicleService.calculateTotalRent() +"\n");

	}
}
