import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public abstract class Room{
    private static int idGenerator = 0;
    private int id;
    private String name;
    private double rate;
    private Customer customer;
    private ArrayList<Reservation> waitlist;

    public Room(String name, double rate) {
        idGenerator++;
        this.id = idGenerator;
        this.name = name;
        this.rate = rate;
        this.waitlist = new ArrayList<>();
    }

    /**
     * Class methods
     */

    public double getRate() {
        return rate;
    }

    public abstract void update();

    public abstract int getUpgradeRate ();

    public void setWaitlist(ArrayList<Reservation> waitlist) {
        this.waitlist = waitlist;
    }

    public void addToWaitlist (Reservation r) {
        this.waitlist.add(r);
    }

    public void getWaitlist() {
        for (int i = 0; i < this.waitlist.size(); i++) {
            System.out.println("Waiting list rank "+i+1+":\n"+this.waitlist.get(i));
        }

    }

    @Override
    public String toString() {
        return "     Room          {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rate=" + rate + "}"
                ;
    }
}