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
 * Service class responsible for managing a collection of vehicles.
 * <p>
 * It provides functionalities to:
 * <ul>
 *   <li>Load vehicle data from a file</li>
 *   <li>Add new vehicles</li>
 *   <li>Search for vehicles by brand and model</li>
 *   <li>Rent vehicles</li>
 *   <li>Calculate total rental price of available vehicles</li>
 * </ul>
 * This class maintains an internal list of {@link Vehicle} objects.
 * </p>
 * 
 * @author Eben
 * @version Java 19
 */
public class VehicleService {

    /**
     * Internal list to store all vehicles loaded from a file or added at runtime.
     */
    private List<Vehicle> vehicleList = new ArrayList<>();

    /**
     * Loads vehicle data from a specified file path. Each line in the file must
     * contain a comma-separated record for a Car or Bike.
     *
     * @param filePath the file path containing vehicle records
     * @return the list of vehicles loaded from the file
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
     * Parses a single line of vehicle data and creates a corresponding {@link Vehicle} object.
     *
     * @param line a comma-separated string representing a vehicle
     * @return a {@link Vehicle} object if parsing is successful, or {@code null} if the format is invalid
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
     * @param vehicle the {@link Vehicle} object to be added
     */
    public void addVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }

    /**
     * Calculates the total rental cost for all currently available vehicles.
     *
     * @return the total rent amount as a double
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

    /**
     * Attempts to rent the given vehicle by marking it as unavailable.
     *
     * @param vehicle the vehicle to be rented
     * @return {@code true} if the vehicle was available and successfully rented,
     *         {@code false} if the vehicle is already rented
     */
    public boolean rentVehicle(Vehicle vehicle) {
        if (vehicle != null && vehicle.isAvailable()) {
            vehicle.setAvaialble(false); // Note: Typo in method name; should be setAvailable
            System.out.println("Vehicle rented: " + vehicle.getBrand() + " " + vehicle.getModel());
            return true;
        } else {
            System.out.println("Vehicle already rented");
            return false;
        }
    }

    /**
     * Retrieves the current list of all vehicles stored in memory.
     *
     * @return a list of {@link Vehicle} objects
     */
    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    /**
     * Searches for a vehicle in the list based on brand and model name.
     *
     * @param brand the brand name to search for
     * @param model the model name to search for
     * @return the matching {@link Vehicle} object if found; otherwise {@code null}
     */
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
