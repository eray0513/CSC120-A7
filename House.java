// import the ArrayList class
import java.util.ArrayList;
/* This is a stub for the House class */
public class House extends Building {

  // Keeps track of the list of people who lives there
  private ArrayList < String > residents;
  // Indicates if the house has a dining room
  private boolean hasDiningRoom;

  /**
   * Default constructor
   */
  public House(){
    super();
    this.hasDiningRoom = true;
    this.hasElevator = false;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Overload constructor with just name and address
   * @param name of house
   * @param address of house
   * @param nFloors number of floors
   */
  public House(String name, String address, int nFloors){
    super(name, address);
    this.nFloors = nFloors;
  }

  /**
   * Constructs a house object, using the Building constructor
   * @param name parameter of super
   * @param address parameter of super
   * @param nFloors parameter of super
   * @param dining whether or not it has a dining room
   */
  public House(String name, String address, int nFloors, boolean dining, boolean hasElevator) {
    super(name, address, nFloors, hasElevator);
    this.residents = new ArrayList < String > ();
    this.hasDiningRoom = dining;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Accessor for dining room boolean
   * @return T/F if there is a dining room
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * Accessor for number of residents
   * @return size of residents array list
   */
  public int nResidents() {
    return this.residents.size();
  }

  /**
   * Allows resident to move in if not already living there
   * @param name String object representing resident
   */
  public void moveIn(String name) {
    if (this.isResident(name)) {
      throw new RuntimeException(name + " already lives here. Move in failed.");
    } else {
      this.residents.add(name);
    }
  }

  /**
   * Overload moveIn method to allow for moving in multiple people at once
   * @param names
   */
  public void moveIn(ArrayList<String> names){
    for(String n : names){
      this.moveIn(n);
    }
  }

  /**
   * Allows a String object, resident, to move in and be added to the Array List
   * @param name String object of person moving in
   * @return the resident's name if they are moved in and a message if not
   */
  public String moveOut(String name) {
    if (this.isResident(name)) {
      this.residents.remove(name);
      return name;
    } else {
      throw new RuntimeException(name + " does not live in this house. Move out failed.");
    }
  }

  /**
   * Allows someone to check if a person is a resident of the house
   * @param name resident to be checked for
   * @return T/F if the person is a resident
   */
  public boolean isResident(String name) {
    if (this.residents.contains(name)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Overrides showOptions method to include House options
   */
  public void showOptions(){
    super.showOptions();
    System.out.println("+ hasDiningRoom \n + nResidents \n + moveIn \n + moveOut \n + isResident \n");
  }

  public static void main(String[] args) {
    // Creates and initializes a house object
    House myHouse = new House("MyHouse", "345 Bayview", 2, false, true);

    // Testing move in and move out methods
    myHouse.moveIn("Evelyn");
    try{
      myHouse.moveIn("Evelyn");
    } catch (Exception e){
      System.out.println(e);
    }

    System.out.println(myHouse.moveOut("Evelyn"));

    try{
      System.out.println(myHouse.moveOut("Evelyn"));
    } catch (Exception e){
      System.out.println(e);
    }

    myHouse.moveIn("Evelyn");

    ArrayList<String> secondYears = new ArrayList<String>();
    secondYears.add("Kylie");
    secondYears.add("Lisa");
    secondYears.add("Renee");

    myHouse.moveIn(secondYears);

    System.out.println(myHouse.moveOut("Kylie"));

    System.out.println(myHouse.moveOut("Lisa"));
  }


}
