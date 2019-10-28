import java.util.Date;

public class Bungalows extends Room{
    private boolean cable;

    public Bungalows(String name, double rate) {
        super(name, rate);
        this.cable = false;
        setType("Bungalows");
    }

    /**
     * Interface Methods
     */
    public void addPatron() {

    }

    public void removePatron() {

    }

    public void makeReservation() {

    }

    public void notification() {

    }

    /**
     * Class methods
     */

    public void addCable(){
        this.cable = true;
        addToRate(20);
    }

    private void addToRate(double i) {
        i = getRate()+i;
    }


    @Override
    public String toString() {
        return super.toString()+
                "cable=" + cable +
                '}';
    }
}
