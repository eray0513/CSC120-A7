/* This is a stub for the Cafe class */
public class Cafe extends Building{

    private int nCoffeeOunces; //inventory of coffee
    private int nSugarPackets; //inventory of sugar
    private int nCreams; //inventory of cream
    private int nCups; //inventory of cups

    /**
     * Default constructor
     */
    public Cafe(){
        super();
        this.nCoffeeOunces = 80;
        this.nSugarPackets = 20;
        this.nCreams = 20;
        this.nCups = 20;
    }

    /**
     * Constructs a cafe object using super class (building)
     * @param name name of cafe
     * @param address address of cafe
     * @param nFloors number of floors
     * @param nCofO initial coffee ounces
     * @param nSugP initial sugar packets
     * @param nCre initial creams
     * @param nCup initial cups
     */
    public Cafe(String name, String address, int nFloors, int nCofO, int nSugP, int nCre, int nCup) {
        super(name, address, nFloors, false);
        this.nCoffeeOunces = nCofO;
        this.nSugarPackets = nSugP;
        this.nCreams = nCre;
        this.nCups = nCup;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Sell a basic, default cup of coffee
     */
    public void sellCoffee(){
        this.nCoffeeOunces -= 10;
        this.nCups -= 1;
    }

    /**
     * Allows to cafe to sell coffee
     * @param size amount of coffee used
     * @param nSugarPackets amount of sugar packets used
     * @param nCreams amount of creams used
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if(this.nCoffeeOunces<=size||this.nSugarPackets<=nSugarPackets||this.nCreams<=nCreams){
            this.restock(size, nSugarPackets, nCreams, 1);
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups --;
    }

    /**
     * Privately called method to restock inventory
     * @param nCoffeeOunces added coffee
     * @param nSugarPackets added sugar
     * @param nCreams added cream
     * @param nCups added cups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }
    
    /**
     * Override showOptions method to show Cafe options
     */
    public void showOptions(){
        super.showOptions();
        System.out.println("+ sellCoffee \n");
    }

    public static void main(String[] args) {
        // Create a cafe object
        Cafe myCafe = new Cafe("MyCafe", "123 Sesame", 4, 200, 300, 250, 100);
        
        // Test sell coffee method and restock method within
        myCafe.sellCoffee(12, 3, 1);
        myCafe.sellCoffee(400, 1000, 10000);

        myCafe.enter();
        myCafe.goToFloor(3);
    }
    
}
