package com.litmus7.vehiclerentalapp;

import java.util.List;

import com.litmus7.vehiclerentalapp.dto.Bike;
import com.litmus7.vehiclerentalapp.dto.Car;
import com.litmus7.vehiclerentalapp.dto.Vehicle;
import com.litmus7.vehiclerentalapp.services.VehicleService;

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

		System.out.println("Loading all data from text file");
		vehicleService.dataFromFile("src/com/litmus7/vehiclerentalapp/vehicles.txt");
		
		displayAvailableVehicles(vehicleService.getVehicleList());

		System.out.println("\nTotal rent for all the vehicles are:" + vehicleService.calculateTotalRent() +"\n");

		// via default constructor
		Car car = new Car();
		System.out.println("--- Enter Car Details ---");
		car.inputDetails();
		vehicleService.addVehicle(car);
		// via parameterized constructor
		Car carParametrerized = new Car("Ferrari", "LaFerrari", 140000.0, 4, false);
		vehicleService.addVehicle(carParametrerized);

		displayAvailableVehicles(vehicleService.getVehicleList());

		System.out.println("\nTotal rent for all the vehicles is: " + vehicleService.calculateTotalRent() +"\n");
		
		System.out.println("\n--- Renting a vehicle ---\n");
		Vehicle yamaha = vehicleService.searchVehicles("Yamaha","R15");
        vehicleService.rentVehicle(yamaha);
        displayAvailableVehicles(vehicleService.getVehicleList());

	}
	
	public static void displayAvailableVehicles(List<Vehicle> vehicleList) {
	    System.out.println("\n--- Available Vehicles ---");
	    System.out.printf("%-10s %-15s %-15s %-10s %-10s\n", "Type", "Brand", "Model", "Rent/Day", "Available");

	    for (Vehicle vehicle : vehicleList) {
	        if (vehicle.isAvailable()) {
	            String type = vehicle instanceof Car ? "Car" : vehicle instanceof Bike ? "Bike" : "Unknown";
	            System.out.printf("%-10s %-15s %-15s %-10.2f %-10s\n",
	                    type,
	                    vehicle.getBrand(),
	                    vehicle.getModel(),
	                    vehicle.rentalPricePerDay(),
	                    vehicle.isAvailable() ? "Yes" : "No");
	        }
	    }
	}


}
