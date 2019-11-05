import java.time.LocalDate;

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
    private boolean reservedFromWaitlist;

    /**
     * Creates a reservation for a specific customer for a specific room
     * @param room Room
     * @param customer Customer
     * @param startDate LocalDate
     * @param endDate LocalDate
     * @param upgradeLen integer
     * @param stayLen integer
     */
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

    }

    // interface Method
    /**
     * Updates the room
     * @return boolean
     */
    public void updateReservation() {
        this.reservedFromWaitlist = true;
    }

    //Local methods
    /**
     * Calculates how much the deposit will be for the reservation given the room used
     * @param upgradeLen integer
     * @param stayLen integer
     * @return double
     */
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

    /**
     * returns the depoist amount
     * @return double
     */
    public double getDeposit() {
        return deposit;
    }

    /**
     * returns the total amount
     * @return double
     */
    public double getTotal() {
        return total;
    }

    /**
     * returns the reservation ID
     * @return integer
     */
    public int getId() {
        return id;
    }

    /**
     * returns the check in day
     * @return LocalDate
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * returns the check out day
     * @return LocalDate
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * returns the room in the reservation
     * @return Room
     */
    public Room getRoom() {
        return room;
    }

    /**
     * returns length of the stay
     * @return integer
     */
    public int getStayLen() {
        return stayLen;
    }


    // setters

    /**
     * set the length of the upgrade in days
     * @param upgradeLen integer
     */
    public void setUpgradeLen(int upgradeLen) {
        this.upgradeLen = upgradeLen;
        this.deposit = makeDeposit(upgradeLen,this.stayLen);
    }

    /**
     * set the length of stay for the reservation
     * @param stayLen integer
     */
    public void setStayLen(int stayLen) {
        this.stayLen = stayLen;
        this.deposit = makeDeposit(this.upgradeLen,stayLen);
    }

    /**
     * set the checkout day for the reservation
     * @param endDate LocalDate
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /**
     * Prints the reservation, room and customer attributes
     * @return String
     */
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

