import java.util.Date;

public class Bungalows extends Room{
    private boolean cable;

    public Bungalows(String name, double rate) {
        super(name, rate);
        this.cable = false;
    }

    /**
     * Class methods
     */

    public int getUpgradeRate () {
        return 20;
    }

    public void update () {
        System.out.println("AC upgrade is $20/night");
    }

    @Override
    public String toString() {
        return super.toString()+
                "     Add on        {cable=" + cable + "}"
                ;
    }
}
