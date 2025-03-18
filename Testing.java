/**
 * A class that tests the functionality of the Catalog and LibraryItem classes.
 * This class has methods for testing adding, removing, retrieving, and displaying items in the catalog.
 * 
 * @author Shauna Lachelier
 */

public class Testing {
    public static void main(String[] args) {
        testAddItem();
        testRemoveItem();
        testGetItem();
        testDisplayCatalog();
        testIDHasDuplicate();
    }

    /**
     * Tests the addItem method of the Catalog class
     * to ensure that an item is added and retrieved correctly.
     */
    public static void testAddItem() {
        Catalog<LibraryItem> catalog = new Catalog<>();
        LibraryItem item = new LibraryItem("Title1", "Author1", 1);
        try {
            catalog.addItem(item);
            assert item.equals(catalog.getItem(1)) : "testAddItem failed.";
            System.out.println("testAddItem succeeded.");
        } catch (IllegalArgumentException e) {
            System.out.println("testAddItem failed. Reason: " + e.getMessage());
        }
    }

    /**
     * Tests the removeItem method of the Catalog class to
     * ensure that an item can be removed from the catalog and is not in the list.
     */
    public static void testRemoveItem() {
        Catalog<LibraryItem> catalog = new Catalog<>();
        LibraryItem item = new LibraryItem("Title1", "Author1", 1);

        try {
            catalog.addItem(item);
            catalog.removeItem(1);
            assert catalog.getItem(1) == null : "testRemoveItem failed to run.";
            System.out.println("testRemoveItem succeeded.");
        } catch (IllegalArgumentException e) {
            System.out.println("testRemoveItem failed. Reason: " + e.getMessage());
        }
    }

    /**
     * Tests the getItem method of the Catalog class to
     * ensure that an item can be pulled from the catalog by its item ID.
     */
    public static void testGetItem() {
        Catalog<LibraryItem> catalog = new Catalog<>();
        LibraryItem item = new LibraryItem("Title1", "Author1", 1);
        try {
            catalog.addItem(item);
            assert item.equals(catalog.getItem(1)) : "testGetItem failed to run.";
            System.out.println("testGetItem succeeded.");
        } catch (IllegalArgumentException e) {
            System.out.println("testGetItem failed. Reason: " + e.getMessage());
        }
    }

    /**
     * Tests the displayCatalog method of the Catalog class to
     * ensure that all items in the catalog are displayable.
     */
    public static void testDisplayCatalog() {
        Catalog<LibraryItem> catalog = new Catalog<>();
        LibraryItem item1 = new LibraryItem("Title1", "Author1", 1);
        LibraryItem item2 = new LibraryItem("Title2", "Author2", 2);
        try{
            catalog.addItem(item1);
            catalog.addItem(item2);
            catalog.displayCatalog();
            System.out.println("testDisplayCatalog succeeded.");
        } catch (IllegalArgumentException e) {
            System.out.println("testDisplayCatalog failed. Reason: " + e.getMessage());
        }
    }

    public static void testIDHasDuplicate() {
        Catalog<LibraryItem> catalog = new Catalog<>();
        LibraryItem item1 = new LibraryItem("Title1", "Author1", 1);
        LibraryItem item2 = new LibraryItem("Title2", "Author2", 1);
        try {
            catalog.addItem(item1);
            catalog.addItem(item2);
            System.out.println("testIDHasDuplicate has no duplicates. No exception was thrown.");
        } catch (IllegalArgumentException e) {
            System.out.println("testIDHasDuplicate succeeded: " + e.getMessage());
        }
    }   
}
