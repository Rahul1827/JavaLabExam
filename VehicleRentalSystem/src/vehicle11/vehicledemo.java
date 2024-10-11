//package entity;
//
//public class MenuItem {
//	private int itemId;
//	private String name;
//	private double price;
//	private boolean isAvailable;
//
//	public MenuItem(int itemId, String name, double price) {
//		this.itemId = itemId;
//		this.name = name;
//		this.price = price;
//		this.isAvailable = true;
//	}
//
//	public int getItemId() {
//		return itemId;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public double getPrice() {
//		return price;
//	}
//
//	public boolean isAvailable() {
//		return isAvailable;
//	}
//
//	public void setAvailable(boolean isAvailable) {
//		this.isAvailable = isAvailable;
//	}
//}
//
//
//
//
//
//
//========================================
//package entity;
//
//public class Order {
//	private MenuItem menuItem;
//	private int quantity;
//
//	public Order(MenuItem menuItem, int quantity) {
//		this.menuItem = menuItem;
//		this.quantity = quantity;
//	}
//
//	public MenuItem getMenuItem() {
//		return menuItem;
//	}
//
//	public int getQuantity() {
//		return quantity;
//	}
//
//	public double getTotalPrice() {
//		return menuItem.getPrice() * quantity;
//	}
//}
//===================================
//package service;
//
//import java.util.ArrayList;
//
//import entity.MenuItem;
//import entity.Order;
//
//
//
//
//public class RestaurantManagement {
//	private ArrayList<MenuItem> menuItems;
//	private ArrayList<Order> orders;
//
//	public RestaurantManagement() {
//		menuItems = new ArrayList<>();
//		orders = new ArrayList<>();
//	}
//
//	public void addMenuItem(MenuItem menuItem) {
//		menuItems.add(menuItem);
//		System.out.println("Menu item " + menuItem.getName() + " added successfully.");
//	}
//
//	public void takeOrder(int itemId, int quantity) {
//		MenuItem menuItem = null;
//
//		for (MenuItem item : menuItems) {
//			if (item.getItemId() == itemId && item.isAvailable()) {
//				menuItem = item;
//				break;
//			}
//		}
//
//		if (menuItem == null) {
//			System.out.println("Menu item not available.");
//			return;
//		}
//
//		Order order = new Order(menuItem, quantity);
//		orders.add(order);
//		System.out.println("Order placed: " + quantity + " x " + menuItem.getName() + " for $" + order.getTotalPrice());
//	}
//
//	public void displayMenu() {
//		System.out.println("Menu Items:");
//		for (MenuItem item : menuItems) {
//			if (item.isAvailable()) {
//				System.out.println(
//						"ID: " + item.getItemId() + ", Name: " + item.getName() + ", Price: $" + item.getPrice());
//			}
//		}
//	}
//
//	public void displayOrders() {
//		System.out.println("Orders:");
//		for (Order order : orders) {
//			System.out.println(
//					order.getQuantity() + " x " + order.getMenuItem().getName() + " for $" + order.getTotalPrice());
//		}
//	}
//}
//
//
//
//
//
//
//
//
//
//
//
//
//================================================
//package vehicle11;
//
//import java.util.Scanner;
//
////import EntityRestaurant.Customer;
////import Test.String;
////import EntityRestaurant.Customer;
////import Test.BufferedReader;
////import Test.Exception;
////import Test.InputStreamReader;
////import Test.NumberFormatException;
//
//import entity.MenuItem;
//import entity.Order;
//import service.RestaurantManagement;
//
//
//
//public class RestaurantManagementSystem {
//	public static void main(String[] args) {
//		
//	
//		
//		Scanner scanner = new Scanner(System.in);
//		RestaurantManagement restaurantManagement = new RestaurantManagement();
//
//		restaurantManagement.addMenuItem(new MenuItem(1, "Burger", 5.99));
//		restaurantManagement.addMenuItem(new MenuItem(2, "Pizza", 8.99));
//		restaurantManagement.addMenuItem(new MenuItem(3, "Pasta", 7.99));
//		restaurantManagement.addMenuItem(new MenuItem(4, "Salad", 4.99));
//		
//
//		
//
//		try {
//		
//		while (true) {
//			System.out.println("\nRestaurant Management System");
//			System.out.println("1. Display Menu");
//			System.out.println("2. Take Order");
//			System.out.println("3. Display Orders");
//			System.out.println("4. Exit");
//			System.out.print("Enter your choice: ");
//			int choice = scanner.nextInt();
//
//			switch (choice) {
//			case 1:
//				restaurantManagement.displayMenu();
//				break;
//
//			case 2:
//				System.out.print("Enter menu item ID: ");
//				int itemId = scanner.nextInt();
//				System.out.print("Enter quantity: ");
//				int quantity = scanner.nextInt();
//				restaurantManagement.takeOrder(itemId, quantity);
//				break;
//
//			case 3:
//				restaurantManagement.displayOrders();
//				break;
//
//			case 4:
//				System.out.println("Exiting the system...");
//				scanner.close();
//				return;
//
//			default:
//				System.out.println("Invalid choice, please try again.");
//			}
//		}
//		
//		}catch (NumberFormatException e) {
//		    System.out.println("Invalid input: Please enter numeric values for order count.");
//	} catch (Exception e) {
//			    System.out.println("An error occurred: " + e.getMessage());
//			}
//		
//		
//		
//	}
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
