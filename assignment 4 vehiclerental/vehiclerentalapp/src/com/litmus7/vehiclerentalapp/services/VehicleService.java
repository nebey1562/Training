package com.litmus7.vehiclerentalapp.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.vehiclerentalapp.dto.Bike;
import com.litmus7.vehiclerentalapp.dto.Car;
import com.litmus7.vehiclerentalapp.dto.Vehicle;

/**
 * Service class responsible for managing a collection of vehicles, including
 * loading from a file, adding new vehicles, and displaying available ones.
 * <p>
 * This class encapsulates vehicle-related data operations.
 * </p>
 * 
 * @author Eben
 * @version Java 19
 */
public class VehicleService {

	// Internal list to store all vehicles loaded or added at runtime
	private List<Vehicle> vehicleList = new ArrayList<>();

	/**
	 * Loads vehicle data from a given file path. Each line in the file should
	 * represent one vehicle record.
	 *
	 * @param filePath path to the input file containing vehicle data
	 */
	public List<Vehicle> dataFromFile(String filePath) {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				Vehicle vehicle = parseVehicle(line);
				if (vehicle != null) {
					vehicleList.add(vehicle);
				}
			}
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getLocalizedMessage());
		}
		return vehicleList;
	}

	/**
	 * Parses a single line of vehicle data and returns a corresponding Vehicle
	 * object.
	 *
	 * @param line the comma-separated line containing vehicle data
	 * @return a Vehicle object if parsing is successful; otherwise null
	 */
	private Vehicle parseVehicle(String line) {
		String[] parts = line.split(",");
		String type = parts[0];

		switch (type) {
		case "Car":
			return new Car(parts[1].trim(), parts[2].trim(), Double.parseDouble(parts[3].trim()),
					Integer.parseInt(parts[4].trim()), Boolean.parseBoolean(parts[5].trim()));
		case "Bike":
			return new Bike(parts[1].trim(), parts[2].trim(), Double.parseDouble(parts[3].trim()),
					Boolean.parseBoolean(parts[4].trim()), Integer.parseInt(parts[5].trim()));
		default:
			System.out.println("Unknown vehicle type");
			return null;
		}
	}

	/**
	 * Adds a new vehicle to the internal list.
	 *
	 * @param vehicle the Vehicle object to add
	 */
	public void addVehicle(Vehicle vehicle) {
		vehicleList.add(vehicle);
	}

	/**
	 * Displays the total amount required to rent all vehicles.
	 */
	public double calculateTotalRent() {
		double totalRent = 0;
		for (Vehicle vehicle : vehicleList) {
			if (vehicle.isAvailable()) {
				totalRent += vehicle.rentalPricePerDay();
			}
		}
		return totalRent;
	}
	
	public boolean rentVehicle(Vehicle vehicle) {
    if (vehicle.isAvailable()) {
        vehicle.setAvaialble(false);
        System.out.println("Vehicle rented: " + vehicle.getBrand() + " " + vehicle.getModel());
        return true;
    } else {
        System.out.println("Vehicle already rented");
        return false;
    }
}
	
	public List<Vehicle> getVehicleList(){
		return vehicleList;
	}

	public Vehicle searchVehicles(String brand, String model) {
	    for (Vehicle vehicle : vehicleList) {
	        if (vehicle.getBrand().equalsIgnoreCase(brand) &&
	            vehicle.getModel().equalsIgnoreCase(model)) {
	            return vehicle;
	        }
	    }
	    return null;
	}

	
}
