import java.util.Date;

public class Cottage extends Room {
    private boolean ac;

    public Cottage(String name, double rate) {
        super(name, rate);
        this.ac = false;
        setType("Cottage");
    }

    /**
     * Interface Methods
     */
    public void addPatron() {

    }

    public void removePatron() {

    }

    public void makeReservation (){

    }

    public void notification() {

    }

    /**
     * Class methods
     */

    public void addAc() {
        this.ac = true;
        // TV add on
        addToRate(5);
    }

    private void addToRate(double i) {
        i = getRate()+i;
    }


    @Override
    public String toString() {

        return super.toString() +
                "ac=" + ac +
                '}';
    }
}
