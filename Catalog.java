import java.util.ArrayList;
import java.util.List;

/**
 * The generic catalog class for storing library item information.
 * Utilizing T as my Generic type parameter and extending it with the LibraryItem class
 * so that I can extend from Library item itself or any of its subclasses.
 * 
 * @param <T>
 * 
 * @author Shauna Lachelier
 */
public class Catalog<T extends LibraryItem> {
    private List<T> items; // Storing the library items in this list.

    // The constructor I'm using to instantiate a new catalog object.
    public Catalog() {
        this.items = new ArrayList<>();
    }

    /**
     * Taking the item object and storing it into the list.
     * 
     * @param item
     * @throws IllegalArgumentException if a duplicate item ID exists.
     */
    public void addItem(T item) throws IllegalArgumentException {
        for (T itemExists : items) {
            if(itemExists.getItemID() == item.getItemID()) {
                throw new IllegalArgumentException("An item with the ID: " + item.getItemID() + " already exists. Please enter a different ID.");
            }
        }
        items.add(item);
    }

    /**
     * Providing functionality to remove an item from the list.
     * 
     * @param itemID removes the item via its ID.
     */
    public void removeItem(int itemID) {
        T itemToRemove = null;
        for (T item : items) {
            if (item.getItemID() == itemID) {
                itemToRemove = item;
                break;
            }
        }
        if (itemToRemove != null) {
            items.remove(itemToRemove);
        } else {
            System.out.println("Item with ID " + itemID + " not found.");
        }
    }

    /**
     * Pulls the item object's ID and returns the item's properties and their values.
     * 
     * @param itemID 
     * @return will display null if the item object with that ID doesn't exist.
     */
    public T getItem(int itemID) {
        for (T item : items) {
            if (item.getItemID() == itemID) {
                return item;
            }
        }
        System.out.println("Item with ID " + itemID + " not found.");
        return null;
    }

    /**
     * This will display all of the items through a for loop.
     */
    public void displayCatalog() {
        for (T item : items) {
            System.out.println(item);
        }
    }
}