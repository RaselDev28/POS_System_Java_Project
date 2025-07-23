public class Product {
    private int id;
    private String name;
    private int quantity;
    private double price;

    public Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    public void addStock(int qty) { this.quantity += qty; }
    public boolean sell(int qty) {
        if (qty <= this.quantity) {
            this.quantity -= qty;
            return true;
        }
        return false;
    }

    public String toString() {
        return id + " | " + name + " | Qty: " + quantity + " | Price: $" + price;
    }
}
