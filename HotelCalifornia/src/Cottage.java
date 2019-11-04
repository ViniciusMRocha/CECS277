import java.util.ArrayList;
import java.util.Date;

public class Cottage extends Room {
    private boolean ac;

    public Cottage(String name, double rate) {
        super(name, rate);
    }


    /**
     * Class methods
     */

    public void notification(){

    }

    public void update () {
        System.out.println("Cable TV upgrade is $5/night");
    }

    public int getUpgradeRate () {
        return 5;
    }

    @Override
    public String toString() {

        return super.toString();
    }
}
