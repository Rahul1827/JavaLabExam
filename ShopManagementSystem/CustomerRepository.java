package ShopManagementSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private final String filePath = "D:\\Rahul Patil\\Rahul patil\\Rahul patil\\LabExamTextFiles\\ShopManagementSystem\\Customer.txt";

    public void saveCustomers(List<Customer> customers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Customer customer : customers) {
                writer.write(customer.getId() + "," + customer.getName() + "," + customer.getPhone());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving customers: " + e.getMessage());
        }
    }

    public List<Customer> loadCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                customers.add(new Customer(parts[0], parts[1], parts[2]));
            }
        } catch (IOException e) {
            System.err.println("Error loading customers: " + e.getMessage());
        }
        return customers;
    }
}
