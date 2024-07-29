import java.util.Arrays;
import java.util.Scanner;

public class SortingCustomerOrders {

    static class Order {
        private int orderId;
        private String customerName;
        private double totalPrice;

        public Order(int orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        public int getOrderId() {
            return orderId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "orderId=" + orderId +
                    ", customerName='" + customerName + '\'' +
                    ", totalPrice=" + totalPrice +
                    '}';
        }
    }

    // Bubble Sort
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    // Swap orders[j] and orders[j + 1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() < pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        // Swap orders[i + 1] and orders[high] (or pivot)
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Example orders
        Order[] orders = {
                new Order(1, "Alice", 250.50),
                new Order(2, "Bob", 150.75),
                new Order(3, "Charlie", 300.00),
                new Order(4, "Diana", 200.00),
                new Order(5, "Edward", 100.25)
        };

        while (true) {
            System.out.println("1. Sort using Bubble Sort");
            System.out.println("2. Sort using Quick Sort");
            System.out.println("-1 to exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bubbleSort(orders);
                    System.out.println("Orders sorted using Bubble Sort:");
                    for (Order order : orders) {
                        System.out.println(order);
                    }
                    break;

                case 2:
                    quickSort(orders, 0, orders.length - 1);
                    System.out.println("Orders sorted using Quick Sort:");
                    for (Order order : orders) {
                        System.out.println(order);
                    }
                    break;

                case -1:
                    System.out.println("Thank you");
                    scanner.close();
                    return;

                default:
                    System.out.println("Incorrect choice. Please try again.");
                    break;
            }
        }
    }
}