import java.util.Date;

public class Cottage extends Room {
    private boolean ac;

    public Cottage(String name, double rate) {
        super(name, rate);
        this.ac = false;
    }


    /**
     * Class methods
     */



    @Override
    public String toString() {

        return super.toString() +
                "ac=" + ac +
                '}';
    }
}
