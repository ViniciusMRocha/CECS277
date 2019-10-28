import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public abstract class Room implements Accomodation {
    private static int idGenerator = 0;
    private int id;
    private String name;
    private double rate;
    private String type;

    public Room(String name, double rate) {
        idGenerator++;
        this.id = idGenerator;
        this.name=name;
        this.rate = rate;
        this.type = type;
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

    public void addToRate(double increment, int days) {
        this.rate = (rate+increment)*days;
    }

    public double getRate() {
        return rate;
    }

    public void calRate(double rate, int days) {
        this.rate = rate*days;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }



    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                ", ";
    }
}