import java.util.Scanner;

public class POS {
    private static ProductManager manager = new ProductManager();

    public static void mainMenu() {
        System.out.println("\n=== POS SYSTEM ===");
        System.out.println("1. Register Product");
        System.out.println("2. Stock In");
        System.out.println("3. Sell Product");
        System.out.println("4. List Products");
        System.out.println("0. Exit");
        System.out.print("Select option: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            mainMenu();
            option = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (option) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int qty = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    manager.registerProduct(name, qty, price);
                    break;
                case 2:
                    manager.listProducts();
                    System.out.print("Enter product ID to stock in: ");
                    int stockId = scanner.nextInt();
                    System.out.print("Enter quantity: ");
                    int stockQty = scanner.nextInt();
                    manager.stockIn(stockId, stockQty);
                    break;
                case 3:
                    manager.listProducts();
                    System.out.print("Enter product ID to sell: ");
                    int sellId = scanner.nextInt();
                    System.out.print("Enter quantity: ");
                    int sellQty = scanner.nextInt();
                    manager.sellProduct(sellId, sellQty);
                    break;
                case 4:
                    manager.listProducts();
                    break;
                case 0:
                    System.out.println("Exiting POS...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (option != 0);

        scanner.close();
    }
}
