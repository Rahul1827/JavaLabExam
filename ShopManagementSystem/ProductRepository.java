package ShopManagementSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private final String filePath = "D:\\Rahul Patil\\Rahul patil\\Rahul patil\\LabExamTextFiles\\ShopManagementSystem\\Product.txt";

    public void saveProducts(List<Product> products) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Product product : products) {
                writer.write(product.getId() + "," + product.getName() + "," + product.getCost() + "," + product.getQuantity());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving products: " + e.getMessage());
        }
    }

    public List<Product> loadProducts() {
        List<Product> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                products.add(new Product(parts[0], parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3])));
            }
        } catch (IOException e) {
            System.err.println("Error loading products: " + e.getMessage());
        }
        return products;
    }
}
