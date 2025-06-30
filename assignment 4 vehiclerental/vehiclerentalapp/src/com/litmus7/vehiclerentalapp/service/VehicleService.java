package com.litmus7.vehiclerentalapp.service;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.vehiclerentalapp.dao.VehicleDao;
import com.litmus7.vehiclerentalapp.dto.Bike;
import com.litmus7.vehiclerentalapp.dto.Car;
import com.litmus7.vehiclerentalapp.dto.Vehicle;
import com.litmus7.vehiclerentalapp.exceptions.DuplicateVehicleException;
import com.litmus7.vehiclerentalapp.exceptions.VehicleDataAccessingException;
import com.litmus7.vehiclerentalapp.exceptions.VehicleServiceException;



/**
 * Service class responsible for managing a collection of vehicles.
 * <p>
 * It provides functionalities to:
 * <ul>
 * <li>Load vehicle data from a file</li>
 * <li>Add new vehicles</li>
 * <li>Search for vehicles by brand and model</li>
 * <li>Rent vehicles</li>
 * <li>Calculate total rental price of available vehicles</li>
 * </ul>
 * This class maintains an internal list of {@link Vehicle} objects.
 * </p>
 * 
 * @author Eben
 * @version Java 19
 */

public class VehicleService {

	// List of Vehicles
	private List<Vehicle> vehicles = new ArrayList<>();

	//DAO used to interact with data layer.
	private VehicleDao dao = new VehicleDao();

	/**
     * Loads vehicles from a specified file path using the DAO.
     *
     * @param filePath the file path to load vehicles from
     * @return the list of loaded vehicles
     * @throws VehicleServiceException if the loading operation fails
	 * @throws IOException 
     */
	public List<Vehicle> loadVehicles(String filePath) throws VehicleServiceException, VehicleDataAccessingException, IOException {
		vehicles = dao.loadVehiclesfromFile(filePath);
		return vehicles;
	}

	/**
	 * Adds a new vehicle to the list.
	 * 
	 * @param vehicle the Vehicle object to add
	 * @return the added vehicle
	 * @throws DuplicateVehicleException if vehicle already exist in the list
	 */
	public Vehicle addVehicle(Vehicle vehicle) throws DuplicateVehicleException {
		for (Vehicle v : vehicles) {
			if (v.equals(vehicle)) {
				throw new DuplicateVehicleException("Vehicle Already Exist");
			}
		}
		vehicles.add(vehicle);
		return vehicle;
	}

	/**
     * Returns a list of all vehicles.
     * 
     * @return a list of all vehicles
     * @throws VehicleServiceException if no vehicles are available
     */
	public List<Vehicle> getAllVehicles() throws VehicleServiceException {
		if (vehicles.isEmpty()) {
			throw new VehicleServiceException("No Vehicles Available to Rent");
		}
		return vehicles;
	}

	/**
	 * Searches for an available vehicle by brand and model.
	 * 
	 * @param brand the brand to search for
	 * @param model the model to search for
	 * @return the first available matching {@link Vehicle}
	 * @throws VehicleServiceException if no matching vehicle found
	 */
	public Vehicle searchVehicles(String brand, String model) throws VehicleServiceException {
		brand = brand.toLowerCase();
		model = model.toLowerCase();

		for (Vehicle vehicle : vehicles) {
			if (vehicle.getBrand().equalsIgnoreCase(brand) && vehicle.getModel().equalsIgnoreCase(model))
				return vehicle;
		}
		throw new VehicleServiceException("Vehicle Not Found");
	}

	/**
	 * Marks a vehicle as rented if it is currently available.
	 * 
	 * @param vehicle the vehicle to rent
	 * @return the updated vehicle marked as rented
	 * @throws VehicleServiceException if the vehicle is already rented
	 */
	public Vehicle rentVehicle(Vehicle vehicle) throws VehicleServiceException {
		if (vehicle.isAvailable()) {
			vehicle.setAvailable(false);
			return vehicle;
		}
		throw new VehicleServiceException("Vehicle Already Rented");
	}

	/**
     * Marks a vehicle as returned (available) if it is currently rented.
     * 
     * @param vehicle the vehicle to return
     * @return the updated vehicle marked as available
     * @throws VehicleServiceException if the vehicle was not rented
     */
	public Vehicle returnVehicle(Vehicle vehicle) throws VehicleServiceException {
		if (!vehicle.isAvailable()) {
			vehicle.setAvailable(true);
			return vehicle;
		}
		throw new VehicleServiceException("Vehicle is not Rented, Hence Cannot be Returned");
	}

	 /**
     * Retrieves a list of currently available vehicles.
     * 
     * @return a list of available vehicles
     * @throws VehicleServiceException if no available vehicles are found
     */
	public List<Vehicle> getAvailableVehicles() throws VehicleServiceException {
		List<Vehicle> available = new ArrayList<>();
		for (Vehicle vehicle : vehicles) {
			if (vehicle.isAvailable())
				available.add(vehicle);
		}
		if (available.isEmpty()) {
			throw new VehicleServiceException("No Available Vehicles");
		}
		return available;
	}
}