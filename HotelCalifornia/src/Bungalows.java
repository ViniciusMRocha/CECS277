import java.util.ArrayList;
import java.util.Date;

public class Bungalows extends Room{
    private boolean ac;

    public Bungalows(String name, double rate) {
        super(name, rate);
    }

    /**
     * Class methods
     */

    public void notification(){

    }

    public int getUpgradeRate () {
        return 20;
    }

    public void update () {
        System.out.println("AC upgrade is $20/night");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
