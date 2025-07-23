import java.util.*;

public class ProductManager {
    private Map<Integer, Product> products = new HashMap<>();
    private int nextId = 1;

    public void registerProduct(String name, int quantity, double price) {
        Product product = new Product(nextId++, name, quantity, price);
        products.put(product.getId(), product);
        System.out.println("Product registered: " + product);
    }

    public void stockIn(int productId, int quantity) {
        Product product = products.get(productId);
        if (product != null) {
            product.addStock(quantity);
            System.out.println("Stock added. New info: " + product);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void sellProduct(int productId, int quantity) {
        Product product = products.get(productId);
        if (product != null) {
            if (product.sell(quantity)) {
                double total = quantity * product.getPrice();
                System.out.println("Sold " + quantity + " of " + product.getName() + ". Total: $" + total);
            } else {
                System.out.println("Insufficient stock.");
            }
        } else {
            System.out.println("Product not found.");
        }
    }

    public void listProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        for (Product product : products.values()) {
            System.out.println(product);
        }
    }
}

