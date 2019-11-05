public class Cottage extends Room {

    /**
     * Creates a room of type cottage
     * @param name String
     * @param rate double
     */
    public Cottage(String name, double rate) {
        super(name, rate);
    }

    // Class Methods

    /**
     * returns the upgraded rate for when a upgrade is requested
     * @return integer
     */
    public int getUpgradeRate () {
        return 5;
    }

    /**
     * Prints out the upgrade message for a Cottage
     */
    public void update () {
        System.out.println("Cable TV upgrade is $5/night");
    }

    /**
     * Print out a cottage attributes
     * @return
     */
    @Override
    public String toString() {

        return super.toString();
    }
}
