import java.util.Arrays;
import java.util.Scanner;

public class ECommercePlatform {

    static class Product {
        private int productId;
        private String productName;
        private String category;

        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        public int getProductId() {
            return productId;
        }

        public String getProductName() {
            return productName;
        }

        public String getCategory() {
            return category;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "productId=" + productId +
                    ", productName='" + productName + '\'' +
                    ", category='" + category + '\'' +
                    '}';
        }
    }

    // Linear search algorithm
    public static Product linearSearch(Product[] products, int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null; // Product not found
    }

    // Binary search algorithm
    public static Product binarySearch(Product[] products, int productId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].getProductId() == productId) {
                return products[mid];
            } else if (products[mid].getProductId() < productId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Product not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Example products for the linear search
        Product[] products = {
                new Product(1, "Laptop", "Electronics"),
                new Product(2, "Smartphone", "Electronics"),
                new Product(3, "Table", "Furniture"),
                new Product(4, "Chair", "Furniture"),
                new Product(5, "Headphones", "Electronics")
        };

        // Example products for the binary search (sorted by productId)
        Product[] sortedProducts = Arrays.copyOf(products, products.length);

        // Sort the array by productId for binary search
        Arrays.sort(sortedProducts, (p1, p2) -> Integer.compare(p1.getProductId(), p2.getProductId()));

        while (true) {
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("-1 to exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter product ID to search: ");
                    int linearSearchId = scanner.nextInt();
                    Product resultLinear = linearSearch(products, linearSearchId);
                    if (resultLinear != null) {
                        System.out.println("Product found: " + resultLinear);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 2:
                    System.out.print("Enter product ID to search: ");
                    int binarySearchId = scanner.nextInt();
                    Product resultBinary = binarySearch(sortedProducts, binarySearchId);
                    if (resultBinary != null) {
                        System.out.println("Product found: " + resultBinary);
                    } else {
                        System.out.println("Product not found.");
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