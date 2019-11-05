import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Room implements Accommodation {
    private static int idGenerator = 0;
    private int id;
    private String name;
    private double rate;
    private Reservation currentReservation;
    private ArrayList<Reservation> waitlist;

    /**
     * Creates a room in the hotel to be reserved by users
     * @param name String
     * @param rate double
     */
    public Room(String name, double rate) {
        idGenerator++;
        this.id = idGenerator;
        this.name = name;
        this.rate = rate;
        this.waitlist = new ArrayList<>();
    }


    // Interface Methods

    /**
     * Attaches a reservation to the room waitlist
     * @param reservation Reservation
     */
    public void addReserve(Reservation reservation) {
        waitlist.add(reservation);
    }

    /**
     * Detach a reservation from the room's waitlist by deleting the reservation
     * @param reservation Reservation
     */
    public void removeReserve(Reservation reservation) {
        this.waitlist.remove(reservation);
    }

    /**
     * When a reservation is canceled the room gets notify and goes over the waitlist to try to add a new reservation to the room
     * @param reservation Reservation
     */
    public void notification(Reservation reservation) {
        removeReserve(reservation);
        System.out.println("Canceling:");
        System.out.println(reservation);

        for (int i = 0; i < this.waitlist.size(); i++) {
            Reservation checkReservation = this.waitlist.get(i);
            if (compareWailist(this.waitlist,checkReservation.getStartDate(),checkReservation.getEndDate())){
                System.out.println("The following reservation is going in effect now");
                System.out.println(checkReservation);
                this.currentReservation = checkReservation;
                break;
            }
            else {
                System.out.println("There are no reservations on the waitlist available to be replace at the moment");
            }
        }
    }

    // class methods

    /**
     * Takes a array list of reservations to compare is the new reservation check in and out days are valid for a new reservation to happen
     * @param allReservations ArrayList
     * @param checkIn LocalDate
     * @param checkOut LocalDate
     * @return boolean
     */
    public boolean compareCheckIn(ArrayList<Reservation> allReservations, LocalDate checkIn, LocalDate checkOut){

        boolean dateValidation = true;
        for (int i = 0; i < allReservations.size(); i++) {
            if ( (checkOut.isBefore(allReservations.get(i).getStartDate()) || checkOut.isEqual(allReservations.get(i).getStartDate())) && (checkIn.isBefore(allReservations.get(i).getStartDate())) ) {
            } else if ( (checkIn.isAfter(allReservations.get(i).getEndDate()) || checkIn.isEqual(allReservations.get(i).getEndDate())) && (checkOut.isAfter(allReservations.get(i).getEndDate())) ) {
            } else {
                dateValidation = false;
            }
        }
        return dateValidation;
    }

    /**
     * Takes the waiting list array list to compare is the new reservation check in and out days are valid for a new reservation to happen
     * @param allReservations ArrayList
     * @param checkIn LocalDate
     * @param checkOut LocalDate
     * @return boolean
     */
    public boolean compareWailist(ArrayList<Reservation> allReservations, LocalDate checkIn, LocalDate checkOut){

        boolean dateValidation = true;
        for (int i = 0; i < allReservations.size(); i++) {
            Reservation checker = allReservations.get(i);
            if ( (checkOut.isBefore(checker.getStartDate()) || checkOut.isEqual(checker.getStartDate())) && (checkIn.isBefore(checker.getStartDate())) ) {
            } else if ( (checkIn.isAfter(checker.getEndDate()) || checkIn.isEqual(checker.getEndDate())) && (checkOut.isAfter(checker.getEndDate())) ) {
            } else if ( (checkIn.isEqual(checker.getStartDate()) || checkIn.isAfter(checker.getStartDate())) && (checkOut.isEqual(checker.getEndDate()) || checkOut.isBefore(checker.getEndDate())) ) {
            } else {
                dateValidation = false;
            }
        }
        return dateValidation;
    }

    /**
     * Polimorphic Method implemented by the child class
     */
    public abstract void update();

    /**
     * Polimorphic Method implemented by the child class
     */
    public abstract int getUpgradeRate ();

    /**
     * Gets the room rate
     * @return double
     */
    public double getRate() {
        return rate;
    }

    /**
     * Returns the current wait list for a specific room
     * @return ArrayList
     */
    public ArrayList<Reservation> getWaitlist() {
        return waitlist;
    }

    /**
     * Returns the room ID
     * @return integer
     */
    public int getId() {
        return id;
    }

    // setters

    /**
     * Set the current reservation for the room
     * @param currentReservation Reservation
     */
    public void setCurrentReservation(Reservation currentReservation) {
        this.currentReservation = currentReservation;
    }

    /**
     * Prints the current waitlist
     */
    public void printWaitlist() {
        for (int i = 0; i < this.waitlist.size(); i++) {
            System.out.println("Waiting list rank "+i+":\n"+this.waitlist.get(i));
        }

    }

    /**
     * Prints the room attributes
     * @return String
     */
    @Override
    public String toString() {
        return "     Room          {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rate=" + rate + "}"
                ;
    }
}