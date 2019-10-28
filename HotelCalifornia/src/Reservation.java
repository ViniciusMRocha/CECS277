import java.util.ArrayList;
import java.util.Date;

public class Reservation {
    private Room room;
    private Customer customer;
    private double deposit;
    private Date startDate;
    private Date endDate;
    private ArrayList<Customer> waitlist;


    public Reservation(Room room, Customer customer, Date startDate, Date endDate) {
        this.room = room;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = makeDeposit();
        // Pass it from main
        //        room.setRate(room.getRate(),4);
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

    public Date getStartDate () {
        return startDate;
    }

    public Date getEndDate () {
        return endDate;
    }

    public int getId () {
        return this.room.getId();
    }




    @Override
    public String toString() {
        return "Reservation{" +
                "room=" + room +
                ", customer=" + customer +
                ", deposit=" + deposit +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", waitlist=" + waitlist +
                '}';
    }
}
