import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
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

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4, false));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4, false));
        myMap.addBuilding(new House("Jordan", "1 Paradise Rd", 4));
        myMap.addBuilding(new House());
        myMap.addBuilding(new Library("Neilson", "7 Neilson Dr", 5, true));
        myMap.addBuilding(new Library());
        myMap.addBuilding(new House("Scale", "170 Elm St", 4, true, true));
        myMap.addBuilding(new Cafe("Woodstar", "60 Masonic St"));
        myMap.addBuilding(new House("Wilson", "1 Paradise Rd", 4));
        myMap.addBuilding(new Cafe("The Roost", "1 Market St", 1, 200, 100, 50, 500));
        myMap.addBuilding(new Cafe());
        myMap.addBuilding(new Library("Forbes", "20 West St", 4, true));

        ArrayList<String> firstYears = new ArrayList<String>();
        firstYears.add("Evelyn");
        firstYears.add("Madeleine");
        firstYears.add("Ruby");
        firstYears.add("Vivi");

        ArrayList<String> newSeries = new ArrayList<String>();

        newSeries.add("Hunger Games by Suzanne Collins");
        newSeries.add("Catching Fire by Suzanne Collins");
        newSeries.add("Mockingjay by Suzanne Collins");

        (Library) myMap.buildings.get(4).addTitle(newSeries);

        System.out.println(myMap);
    }
    
}
