// import Hashtable class
import java.util.Hashtable;
/* This is a stub for the Library class */
public class Library extends Building {

  // Creates a hashtable to store the books and whether they are available
  private Hashtable < String, Boolean > collection;

  /**
   * Constructs a library object that uses the building superclass and initializes the collection to be empty
   * @param name name of library (superclass)
   * @param address address of library (superclass)
   * @param nFloors number of floors (superclass)
   */
  public Library(String name, String address, int nFloors, boolean hasElevator) {
    super(name, address, nFloors, hasElevator);
    this.collection = new Hashtable < String, Boolean > ();
    System.out.println("You have built a library: 📖");
  }

  /**
   * Add a title to the collection and set it to available (true)
   * @param title of book
   */
  public void addTitle(String title) {
    this.collection.put(title, true);
  }

  /**
   * Removes a title from the collection
   * @param title of the book (key)
   * @return String of book that was removed or error message
   */
  public String removeTitle(String title) {
    String result;
    if (this.containsTitle(title)) {
      this.collection.remove(title, true);
      result = title;
      return result;
    } else {
      throw new RuntimeException("The library does not contain this title.");
    }
  }

  /**
   * Allows books to be checked out if they are in the library and available
   * @param title of book being checked out (key)
   */
  public void checkOut(String title) {
    if (this.containsTitle(title)) {
      if (this.isAvailable(title)) {
        this.collection.replace(title, false);
      } else {
        throw new RuntimeException("This title is not available at this time.");
      }
    } else {
      throw new RuntimeException("The library does not contain this title");
    }
  }

  /**
   * Allows books to be returned to the library
   * @param title of the book (key)
   */
  public void returnBook(String title) {
    if (this.containsTitle(title)) {
      this.collection.replace(title, true);
    } else {
      System.out.println("The library does not contain this title.");
    }
  }

  /**
   * Checks if the collection contains a title
   * @param title of the book (key)
   * @return T/F if the title is in the collection
   */
  public boolean containsTitle(String title) {
    return this.collection.containsKey(title);
  }

  /**
   * Checks if a title is available
   * @param title of the book (key)
   * @return T/F if the book is available
   */
  public boolean isAvailable(String title) {
    if(this.containsTitle(title)){
      return this.collection.get(title);
    } else{
      return false;
    }
  }

  /**
   * Prints the collection by iterating over the hashtable
   */
  public void printCollection() {
    System.out.println("\nCollection: " + "\n");
    for (String key: this.collection.keySet()) {
      String available = "Unavailable";
      if (this.collection.get(key) == true) {
        available = "Available";
      }
      System.out.println(key + ": " + available);
    }
  }

  /**
   * Override showOptions method to include library options
   */
  public void showOptions(){
    super.showOptions();
    System.out.println("+ addTitle \n + removeTitle \n + checkOut \n + returnBook \n + containsTitle \n + isAvailable \n + printCollection \n");
  }

  public static void main(String[] args) {
    // Create a library object
    Library myLibrary = new Library("Neilson", "1 Green St", 4, true);

    // Can print empty collection
    myLibrary.printCollection();

    // Test add books to collection
    myLibrary.addTitle("Percy Jackson by Rick Riordan");
    myLibrary.addTitle("The Mysterious Benedict Society by Lisa Lisa");
    myLibrary.addTitle("I Can't Think of Anything by Evelyn Ray");
    myLibrary.addTitle("Free Will by Rvelyn Eay");

    // Test removing books
    System.out.println(myLibrary.removeTitle("Percy Jackson by Rick Riordan"));
    try{
      System.out.println(myLibrary.removeTitle("Percy Jackson by Rick Riordan"));
    }catch(Exception e){
      System.out.println("The library does not contain this title.");
    }
    myLibrary.addTitle("Percy Jackson by Rick Riordan");

    // Test checking out and returning books
    myLibrary.checkOut("Percy Jackson by Rick Riordan");
    try{
    myLibrary.checkOut("Percy Jackson by Rick Riordan");
    } catch(Exception e){
      System.out.println("This title is not available at this time.");
    }

    try{
      myLibrary.checkOut("I'm not real by no one");
    } catch(Exception e){
      System.out.println("The library does not contain this title.");
    }

    myLibrary.returnBook("Percy Jackson by Rick Riordan");
    myLibrary.checkOut("Percy Jackson by Rick Riordan");

    // Test printing collection
    myLibrary.printCollection();

  }

}