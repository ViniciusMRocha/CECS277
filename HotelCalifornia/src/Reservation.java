import java.util.ArrayList;
import java.util.Date;

public class Reservation implements Accomodation{
    private static int idGenerator = 0;
    private int id;
    private Room room;
    private Customer customer;
    private double deposit;
    private Date startDate;
    private Date endDate;
    private ArrayList<Customer> waitlist;
    private double total;


    public Reservation(Room room, Customer customer, Date startDate, Date endDate) {
        idGenerator++;
        this.id = idGenerator;
        this.room = room;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = makeDeposit();
        // Pass it from main
        //        room.setRate(room.getRate(),4);
    }

    public Reservation(Room room, Date startDate, Date endDate) {
        idGenerator++;
        this.id = idGenerator;
        this.room = room;
        this.customer = null;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = makeDeposit();
        this.total = 0;
        // Pass it from main
        //        room.setRate(room.getRate(),4);
    }

    /**
     * Interface Methods
     */

    public void addPatron(Customer customer) {
        this.customer = customer;
    }

    // add the next patron from the waiting list
    public void removePatron(Customer customer) { this.customer = null; }

    public void notification() {

    }


    public double getTotal() {
        return total;
    }

    /**
     * Local methods
     */


    public void setTotal (double rate, int days) {
        this.total = rate*days;
    }

    public void addToTotal(double increment, int days) {
        this.total = (room.getRate()+increment)*days;
    }


    public int getId() {
        return id;
    }

    public double makeDeposit () {
        double result = 0;
        if (room instanceof Cottage) {
            result = room.getRate()*0.5;
        } else if (room instanceof Bungalows) {
            result = room.getRate()*0.2;
        }
        return result;

    }

    public Date getStartDate () { return startDate; }

    public Date getEndDate () {
        return endDate;
    }

    @Override
    public String toString() {
        return "Reservation " + id + "\n" +
                "     " + room + "\n" +
                "     " + customer + "\n" +
                "     General Info  {" +
                "deposit=" + deposit +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' + "}\n" +
                "     Waitlist      {" + waitlist + "}\n"
                ;
    }
}
