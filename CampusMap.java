import java.util.ArrayList;
import java.util.Scanner;

public class CampusMap {

  ArrayList < Building > buildings;

  /* Default constructor, initializes empty ArrayList */
  public CampusMap() {
    buildings = new ArrayList < Building > ();
  }

  /**
   * Adds a Building to the map
   * @param b the Building to add
   */
  public void addBuilding(Building b) {
    System.out.println("Adding building...");
    buildings.add(b);
    System.out.println("-->Successfully added " + b.getName() + " to the map.");
  }

  /**
   * Removes a Building from the map
   * @param b the Building to remove
   * @return the removed Building
   */
  public Building removeBuilding(Building b) {
    System.out.println("Removing building...");
    buildings.remove(b);
    System.out.println("-->Successfully removed " + b.getName() + " to the map.");
    return b;
  }

  public String toString() {
    String mapString = "DIRECTORY of BUILDINGS";

    for (int i = 0; i < this.buildings.size(); i++) {
      mapString += "\n  " + (i + 1) + ". " + this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
    }
    return mapString;
  }

  public static void main(String[] args) {

    // New map object
    CampusMap myMap = new CampusMap();

    // Create building objects
    Building ford = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4, false);
    Building bass = new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4, false);
    House jordan = new House("Jordan", "1 Paradise Rd", 4);
    House unknown = new House();
    Library neilson = new Library("Neilson", "7 Neilson Dr", 5, true);
    Library unknown2 = new Library();
    House scales = new House("Scales", "170 Elm St", 4, true, true);
    Cafe woodstar = new Cafe("Woodstar", "60 Masonic St");
    House wilson = new House("Wilson", "1 Paradise Rd", 4);
    Cafe roost = new Cafe("The Roost", "1 Market St", 1, 200, 100, 50, 500);
    Cafe unknown3 = new Cafe();
    Library forbes = new Library("Forbes", "20 West St", 4, true);

    // Add buildings to map
    myMap.addBuilding(ford);
    myMap.addBuilding(bass);
    myMap.addBuilding(jordan);
    myMap.addBuilding(unknown);
    myMap.addBuilding(neilson);
    myMap.addBuilding(unknown2);
    myMap.addBuilding(scales);
    myMap.addBuilding(woodstar);
    myMap.addBuilding(wilson);
    myMap.addBuilding(roost);
    myMap.addBuilding(unknown3);
    myMap.addBuilding(forbes);

    // Test moving in with an ArrayList
    ArrayList < String > firstYears = new ArrayList < String > ();
    firstYears.add("Evelyn");
    firstYears.add("Madeleine");
    firstYears.add("Ruby");
    firstYears.add("Vivi");

    jordan.moveIn(firstYears);

    // Test adding titles with an ArrayList
    ArrayList < String > newSeries = new ArrayList < String > ();
    newSeries.add("Hunger Games by Suzanne Collins");
    newSeries.add("Catching Fire by Suzanne Collins");
    newSeries.add("Mockingjay by Suzanne Collins");

    neilson.addTitle(newSeries);

    // Test selling default coffee
    woodstar.sellCoffee();

    // Print map of buildings
    System.out.println(myMap);

    // Create scanner object
    Scanner input = new Scanner(System.in);

    // Determines if the loop continues
    boolean cont = true;

    // Prompts user
    System.out.println("Welcome to Smith College! Pick a building to enter by typing its cooresponding number. You can stop the adventure at anytime by entering STOP.");

    // Creates variable to store user's choice
    int choice;

    // Catches non-integer choices
    try {
      choice = input.nextInt();
    } catch (Exception TypeMismatchException) {
      choice = 1;
      System.out.println("Non-integer detected. Entering default building one.");
    }

    // Allows user to enter and see options for buildings until they ask to stop
    while (cont) {
      int current = choice - 1;
      myMap.buildings.get(current).enter(); // Enter chosen building
      myMap.buildings.get(current).showOptions(); // Print the options
      
      System.out.println("Where would you like to go next? Enter STOP to exit the adventure.");
      // Catches non integers and sees if they are a stop command
      try {
        choice = input.nextInt();
      } catch (Exception TypeMismatchException) {
        System.out.println("Are you sure you want to quit? If yes, enter STOP. If no, enter CONTINUE.");
        input.nextLine();
        String leaveLoop = input.next();
        if (leaveLoop.equals("STOP")) {
          cont = false;
          System.out.println("Goodbye!");
          break;
        } else {
          System.out.println("Enter an integer for the building you would like to enter.");
          choice = input.nextInt();
        }
      }
      // Exit current building
      myMap.buildings.get(current).exit();
    }
    // Close scanner object
    input.close();
  }
}