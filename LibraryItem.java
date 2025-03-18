/**
 * A class for structuring the library item objects that will be placed in the catalog.
 * 
 * @param title  Name of the item.
 * @param author Author of the item.
 * @param itemID The item's user-specified ID.
 * 
 * @author Shauna Lachelier
 */
public class LibraryItem {
  private String title;
  private String author;
  private int itemID;

  /**
   * The LibraryItem constructor that will include it's title, author, and itemID.
   * 
   * @param title
   * @param author
   * @param itemID
   */
  public LibraryItem(String title, String author, int itemID) {
      this.title = title;
      this.author = author;
      this.itemID = itemID;
  }

  /**
   * This just returns the value of the title for the current item.
   * @return the item's title.
   */
  public String getTitle() {
      return title;
  }

  /**
   * returns the value of the author property for the current item.
   * 
   * @return value of the author property.
   */
  public String getAuthor() {
      return author;
  }

  /**
   * returns the value of the ID for the current item.
   * 
   * @return item's ID.
   */
  public int getItemID() {
      return itemID;
  }

  /**
   * Converts it all to display as a string.
   * 
   * @return The string including the current item's data.
   */
  @Override
  public String toString() {
      return "LibraryItem{" +
              "title='" + title + '\'' +
              ", author='" + author + '\'' +
              ", itemID='" + itemID + '\'' +
              '}';
  }
}