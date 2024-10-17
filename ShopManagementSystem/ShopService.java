package ShopManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class ShopService {
    private final ProductRepository productRepo;
    private final CustomerRepository customerRepo;
    private List<Product> productList;
    private List<Customer> customerList;

    public ShopService() {
        productRepo = new ProductRepository();
        customerRepo = new CustomerRepository();
        productList = productRepo.loadProducts();
        customerList = customerRepo.loadCustomers();
    }

  
    public void addProduct(Product product) {
        productList.add(product);
        productRepo.saveProducts(productList);
    }

    
    public void updateProduct(String productId, int quantity) throws Exception {
        for (Product product : productList) {
            if (product.getId().equals(productId)) {
                product.setQuantity(quantity);
                productRepo.saveProducts(productList);
                return;
            }
        }
        throw new Exception("Product not found.");
    }

        public void removeProduct(String productId) throws Exception {
        Product toRemove = null;
        for (Product product : productList) {
            if (product.getId().equals(productId)) {
                toRemove = product;
                break;
            }
        }
        if (toRemove != null) {
            productList.remove(toRemove);
            productRepo.saveProducts(productList);
        } else {
            throw new Exception("Product not found.");
        }
    }

   
    public void registerCustomer(Customer customer) {
        customerList.add(customer);
        customerRepo.saveCustomers(customerList);
    }

   
    public double processSale(String productId, int quantity) throws Exception {
        for (Product product : productList) {
            if (product.getId().equals(productId)) {
                if (product.getQuantity() < quantity) {
                    throw new Exception("Insufficient stock.");
                }
                product.setQuantity(product.getQuantity() - quantity);
                productRepo.saveProducts(productList);
                return product.getCost() * quantity;
            }
        }
        throw new Exception("Product not found.");
    }

   
    public List<Product> getAllProducts() {
        return productList;
    }

  
    public List<Customer> getAllCustomers() {
        return customerList;
    }
}
