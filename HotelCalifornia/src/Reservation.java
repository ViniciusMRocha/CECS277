import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Reservation implements Accomodation{
    private static int idGenerator = 0;
    private int id;
    private Room room;
    private Customer customer;
    private double deposit;
    private LocalDate startDate;
    private LocalDate endDate;
    private double total;
    private int upgradeLen;
    private int stayLen;
    private boolean available;


    public Reservation(Room room, Customer customer, LocalDate startDate, LocalDate endDate) {
        idGenerator++;
        this.id = idGenerator;
        this.room = room;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.available = true;
    }

    public Reservation(Room room, Customer customer, LocalDate startDate, LocalDate endDate, int upgradeLen, int stayLen) {
        idGenerator++;
        this.id = idGenerator;
        this.room = room;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.upgradeLen = upgradeLen;
        this.stayLen = stayLen;
        this.deposit = makeDeposit(upgradeLen,stayLen);
        this.available = true;
    }

    /**
     * Interface Methods
     */

    public void addPatron(Customer customer) {
        this.customer = customer;
    }

    // add the next patron from the waiting list
    public void removePatron() {
        this.customer = null;
        // run notification
        // runs a addPatron
    }

    public void notification() {
//        // ask patron interface if the next customer in the waiting list wants to be added in
//        // iterate over the the waiting list
//        for (int i = 0; i < waitlist.size(); i++) {
//            waitlist.get(i).update();
//            // if TRUE stops and add that customer to the reservation
//            // else keep going
//            // if the end was reached do not attach any customer
//        }

    }


    /**
     * Local methods
     */

    public LocalDate covertDate (String d) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(d,formatter);
        return date;
    }


    public double makeDeposit (int upgradeLen, int stayLen) {
        double result = 0;
        double upgradeTotal = room.getUpgradeRate()*upgradeLen;
        double stayTotal = room.getRate()*stayLen;
        this.total = upgradeTotal+stayTotal;

        if (room instanceof Cottage) {
            result = total*0.5;
        } else if (room instanceof Bungalows) {
            result = total*0.2;
        }
        return result;
    }

    public double getDeposit() {
        return deposit;
    }

    public double getTotal() {
        return total;
    }

    public int getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Room getRoom() {
        return room;
    }

    public int getUpgradeLen() {
        return upgradeLen;
    }

    public int getStayLen() {
        return stayLen;
    }

    public boolean isAvailable() {
        return available;
    }

    // setters

    public void setUpgradeLen(int upgradeLen) {
        this.upgradeLen = upgradeLen;
        this.deposit = makeDeposit(upgradeLen,this.stayLen);
    }

    public void setStayLen(int stayLen) {
        this.stayLen = stayLen;
        this.deposit = makeDeposit(this.upgradeLen,stayLen);
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Reservation " + id + "\n" +
                room + "\n" +
                "     " + customer + "\n" +
                "     General Info  {" +
                "deposit=" + deposit +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", stayLength='" + stayLen + '\'' +
                ", upgradeLength='" + upgradeLen + '\'' +
                "}\n";
    }
}
