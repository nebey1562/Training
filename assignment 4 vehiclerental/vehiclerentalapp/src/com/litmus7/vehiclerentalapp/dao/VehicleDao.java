package com.litmus7.vehiclerentalapp.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.vehiclerentalapp.dto.Bike;
import com.litmus7.vehiclerentalapp.dto.Car;
import com.litmus7.vehiclerentalapp.dto.Vehicle;
import com.litmus7.vehiclerentalapp.exceptions.VehicleDataAccessingException;

public class VehicleDao {
	
	private List<Vehicle> vehicles = new ArrayList<>();
	
	public List<Vehicle>loadVehiclesfromFile(String filePath) throws IOException, VehicleDataAccessingException{
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				Vehicle vehicle =parseVehicle(line);
				if (vehicle != null)
					vehicles.add(vehicle);
			}
		} catch (FileNotFoundException e) {
			throw new VehicleDataAccessingException("Couldn't load data from :"+ filePath, e);
		} catch (IOException e) {
			throw new VehicleDataAccessingException("Couldn't load data from :"+ filePath, e);
		}
		return vehicles;
	}
	
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
	

}
