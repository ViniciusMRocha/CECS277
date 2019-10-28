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


    @Override
    public String toString() {
        return super.toString()+
                "cable=" + cable +
                '}';
    }
}
