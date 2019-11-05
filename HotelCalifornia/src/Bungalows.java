public class Bungalows extends Room{

    /**
     * Creates a room of type bungalow
     * @param name String
     * @param rate double
     */
    public Bungalows(String name, double rate) {
        super(name, rate);
    }

    // Class Methods

    /**
     * returns the upgraded rate for when a upgrade is requested
     * @return integer
     */
    public int getUpgradeRate () {
        return 20;
    }

    /**
     * Prints out the upgrade message for a Bungalow
     */
    public void update () {
        System.out.println("AC upgrade is $20/night");
    }

    /**
     * Print out a bungalow attributes
     * @return
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
