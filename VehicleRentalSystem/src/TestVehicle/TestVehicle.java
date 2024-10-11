package TestVehicle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import Entity.*;
import Exception.InvalidVehicleException;
import ServiceVehicle.*;
import java.util.Scanner;

public class TestVehicle {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		RentalService rentalService = new RentalService();

		Scanner sc = new Scanner(System.in);

		try {

			System.out.println("Welcome to vehicle shop");
			System.out.println("1. Vehicle On Rent");

			System.out.println("Enter your choice");
			int choice = sc.nextInt();

			switch (choice) {

			case 1:

				System.out.println("vehicle on rent");

				System.out.print("How many vehicles  do you want on rent  ");
				int numberOfRentals = Integer.parseInt(reader.readLine());

				for (int i = 0; i < numberOfRentals; i++) {
					System.out.println("\n--- Customer " + (i + 1) + " ---");

					System.out.print("Enter your name: ");
					String name = reader.readLine();
					System.out.print("Enter your email: ");
					String email = reader.readLine();
					Customer customer = new Customer(name, email);

					System.out.print("Enter vehicle Company: ");
					String vehicleMake = reader.readLine();
					System.out.print("Enter vehicle model: ");
					String vehicleModel = reader.readLine();
					System.out.print("Enter vehicle liscense Number: ");
					String licensePlate = reader.readLine();
					Vehicle vehicle = new Vehicle(vehicleMake, vehicleModel, licensePlate);

					System.out.print("For how much days do you want a vehicle : ");
					int rentalDays = Integer.parseInt(reader.readLine());
					System.out.print("Enter daily rental rate: ");
					double dailyRate = Double.parseDouble(reader.readLine());

					Rental rental = new Rental(customer, vehicle, rentalDays, dailyRate);
					rentalService.addRental(rental);

					rental.displayRentalDetails();
				}

				rentalService.saveAllRentalsToFile("VehicleDetails.txt");

				rentalService.displayAllRentals();

			}

		} catch (InvalidVehicleException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("Invalid input: Please enter numeric values for rental days and daily rate.");
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		}

	}
}
