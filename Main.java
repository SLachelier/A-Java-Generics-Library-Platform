import java.util.Scanner;

/**
 * A CLI for users to add, remove, view and delete items in the catalog.
 * 
 * @author Shauna Lachelier
 */

public class Main {
    public static void main(String[] args) {
        Catalog<LibraryItem> catalog = new Catalog<>();
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("Enter command (add, remove, view, exit): ");
            command = scanner.nextLine();

            if (command.equalsIgnoreCase("add")) {
                System.out.println("Book or movie title: ");
                String title = scanner.nextLine();
                System.out.println("Enter author or creator: ");
                String author = scanner.nextLine();
                int itemID;

                while (true) {
                    System.out.println("Enter a unique numerical item ID: ");
                    try {
                        itemID = Integer.parseInt(scanner.nextLine());
                        LibraryItem item = new LibraryItem(title, author, itemID);
                        catalog.addItem(item);

                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID format. Please try again.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("That item ID already exists. Please try again.");
                    }
                }
            } else if (command.equalsIgnoreCase("remove")) {
                System.out.println("Enter the numerical item ID for the item you want to remove: ");
                try {
                    int itemID = Integer.parseInt(scanner.nextLine());
                    catalog.removeItem(itemID);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid ID format. Please try again.");
                }
            } else if (command.equalsIgnoreCase("view")) {
                catalog.displayCatalog();
            } else if (command.equalsIgnoreCase("exit")) {
                System.out.println("Exiting catalog...");
                break;
            } else {
                System.out.println("Invalid command. Please try again.");
            }
        }

        scanner.close();
    }
}