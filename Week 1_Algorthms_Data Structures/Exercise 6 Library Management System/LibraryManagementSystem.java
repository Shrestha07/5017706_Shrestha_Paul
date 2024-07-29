import java.util.Arrays;
import java.util.Scanner;

public class LibraryManagementSystem {

    static class Book {
        private int bookId;
        private String title;
        private String author;

        public Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        public int getBookId() {
            return bookId;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "bookId=" + bookId +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    '}';
        }
    }

    // Linear search to find a book by title
    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // Book not found
    }

    // Binary search to find a book by title (requires sorted array)
    public static Book binarySearch(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Book not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Example books
        Book[] books = {
                new Book(1, "Harry Potter", "J.K. Rowling"),
                new Book(2, "Twisted Love", "Ana Huang"),
                new Book(3, "1984", "George Orwell"),
                new Book(4, "The Great Gatsby", "F. Scott Fitzgerald"),
                new Book(5, "Feluda Somogro", "Satyajit Ray")
        };

        // Sort the array by title for binary search
        Arrays.sort(books, (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));

        while (true) {
            System.out.println("1. Linear Search by Title");
            System.out.println("2. Binary Search by Title");
            System.out.println("-1 to exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title to search: ");
                    String linearSearchTitle = scanner.nextLine();
                    Book resultLinear = linearSearch(books, linearSearchTitle);
                    if (resultLinear != null) {
                        System.out.println("Book found: " + resultLinear);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 2:
                    System.out.print("Enter book title to search: ");
                    String binarySearchTitle = scanner.nextLine();
                    Book resultBinary = binarySearch(books, binarySearchTitle);
                    if (resultBinary != null) {
                        System.out.println("Book found: " + resultBinary);
                    } else {
                        System.out.println("Book not found.");
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