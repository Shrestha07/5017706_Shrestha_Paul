import documents.Document;
import factories.DocumentFactory;
import factories.ExcelDocumentFactory;
import factories.PdfDocumentFactory;
import factories.WordDocumentFactory;

import java.util.Scanner;

public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose document type to create:");
        System.out.println("1. Word Document");
        System.out.println("2. PDF Document");
        System.out.println("3. Excel Document");
        int choice = scanner.nextInt();

        DocumentFactory factory = null;
        switch (choice) {
            case 1:
                factory = new WordDocumentFactory();
                break;
            case 2:
                factory = new PdfDocumentFactory();
                break;
            case 3:
                factory = new ExcelDocumentFactory();
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        Document document = factory.createDocument();
        document.open();
        document.close();
    }
}