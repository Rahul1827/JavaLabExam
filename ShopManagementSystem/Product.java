package ShopManagementSystem;

public class Product {
    private String id;
    private String name;
    private double cost;
    private int quantity;

    public Product(String id, String name, double cost, int quantity) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
    }

  
    public String getId() { return id; }
    public String getName() { return name; }
    public double getCost() { return cost; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

   
    public String toString() {
        return String.format("ID: %s, Name: %s, Cost: %.2f, Quantity: %d", id, name, cost, quantity);
    }
}
