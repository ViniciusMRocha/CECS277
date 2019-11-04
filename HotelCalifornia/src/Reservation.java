import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation implements Reserve{
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
    private boolean inEffect;


    public Reservation(Room room, Customer customer, LocalDate startDate, LocalDate endDate) {
        idGenerator++;
        this.id = idGenerator;
        this.room = room;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.inEffect = true;
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
        this.inEffect = true;
    }

    /**
     * Interface Methods
     */

    public boolean update() {
        return true;
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

    public boolean isInEffect() {
        return inEffect;
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

    public void notInEffect() {
        this.inEffect = false;
    }

    public void inEffect() {
        this.inEffect = true;
    }

    public boolean getInEffect() {
        return inEffect;
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
                "in effect=" + inEffect +
                ", deposit=" + deposit +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", stayLength='" + stayLen + '\'' +
                ", upgradeLength='" + upgradeLen + '\'' +
                "}\n";
    }
}

