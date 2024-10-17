package ShopManagementSystem;


	import java.util.List;
	import java.util.Scanner;

	public class ShopManagementSystemMain {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        ShopService shopService = new ShopService();

	        while (true) {
	            System.out.println("\n1. Add Product");
	            System.out.println("2. Update Product");
	            System.out.println("3. Remove Product");
	            System.out.println("4. Register Customer");
	            System.out.println("5. Process Sale");
	            System.out.println("6. View Products");
	            System.out.println("7. View Customers");
	            System.out.println("8. Exit");
	            System.out.print("Choose an option: ");

	            int choice = scanner.nextInt();
	         

	            try {
	                switch (choice) {
	                    case 1:
	                        System.out.println("Enter Product ID: ");
	                        String productId = scanner.next();
	                        System.out.print("Enter Product Name: ");
	                        String productName = scanner.next();
	                        System.out.print("Enter Product Cost: ");
	                        double productCost = scanner.nextDouble();
	                        System.out.print("Enter Product Quantity: ");
	                        int productQuantity = scanner.nextInt();
	                        shopService.addProduct(new Product(productId, productName, productCost, productQuantity));
	                        System.out.println("Product added successfully.");
	                        break;

	                    case 2:
	                        System.out.print("Enter Product ID to update: ");
	                        String updateId = scanner.next();
	                        System.out.print("Enter New Quantity: ");
	                        int newQuantity = scanner.nextInt();
	                        shopService.updateProduct(updateId, newQuantity);
	                        System.out.println("Product updated successfully.");
	                        break;

	                    case 3:
	                        System.out.print("Enter Product ID to remove: ");
	                        String removeId = scanner.next();
	                        shopService.removeProduct(removeId);
	                        System.out.println("Product removed successfully.");
	                        break;

	                    case 4:
	                        System.out.print("Enter Customer ID: ");
	                        String customerId = scanner.next();
	                        System.out.print("Enter Customer Name: ");
	                        String customerName = scanner.next();
	                        System.out.print("Enter Customer Phone: ");
	                        String customerPhone = scanner.next();
	                        shopService.registerCustomer(new Customer(customerId, customerName, customerPhone));
	                        System.out.println("Customer registered successfully.");
	                        break;

	                    case 5:
	                        System.out.print("Enter Product ID for sale: ");
	                        String saleProductId = scanner.next();
	                        System.out.print("Enter Quantity: ");
	                        int quantity = scanner.nextInt();
	                        double total = shopService.processSale(saleProductId, quantity);
	                        System.out.printf("Sale processed. Total amount: %.2f%n", total);
	                        break;

	                    case 6:
	                        List<Product> products = shopService.getAllProducts();
	                        System.out.println("Products:");
	                        for (Product product : products) {
	                            System.out.println(product);
	                        }
	                        break;

	                    case 7:
	                        List<Customer> customers = shopService.getAllCustomers();
	                        System.out.println("Customers:");
	                        for (Customer customer : customers) {
	                            System.out.println(customer);
	                        }
	                        break;

	                    case 8:
	                        System.out.println("Exiting...");
	                        return;

	                    default:
	                        System.out.println("Invalid option. Try again.");
	                }
	            } catch (Exception e) {
	                System.out.println("Error: " + e.getMessage());
	            }
	        }
	    }
	}
