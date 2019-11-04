import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public abstract class Room implements Accomodation{
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
     * Interface Methods
     */

    public void addReserve(Reservation reservation) {
        waitlist.add(reservation);
        reservation.notInEffect();
    }

    public void removeReserve(Reservation reservation) {
        reservation.inEffect();
    }

    public void notification(Reservation reservation) {

        System.out.println("\nReservation was canceled\n");

        for (int i = 0; i < this.waitlist.size(); i++) {
            System.out.println(this.waitlist.get(i));
        }
        System.out.println("Done printing the waitlist, will try to reserve");

        boolean passed = compareCheckIn(this.waitlist,reservation.getStartDate(),reservation.getEndDate());


        if (passed) {
            System.out.println("It passed");
        } else {
            System.out.println("not passed");
        }

        System.out.println("New reservation was made upon the recent cancellation");
    }

    /**
     * Class methods
     */



    public boolean compareCheckIn(ArrayList<Reservation> allReservations, LocalDate checkIn, LocalDate checkOut){

        Boolean dateValidation = true;
        for (int i = 0; i < allReservations.size(); i++) {

            if (!allReservations.get(i).getInEffect()) {
                if (checkIn.isBefore(allReservations.get(i).getStartDate())     &&      (checkOut.isBefore(allReservations.get(i).getStartDate()) || checkOut.isEqual(allReservations.get(i).getStartDate()))
                ) {
                    // System.out.println("Clear");
                } else if ((checkIn.isAfter(allReservations.get(i).getEndDate()) || checkIn.isEqual(allReservations.get(i).getEndDate()))     &&      checkOut.isAfter(allReservations.get(i).getEndDate())) {
                    // System.out.println("Clear");
                } else {
                    // System.out.println(" NOT CLEAR");
                    dateValidation = false;
                }
            }
        }
        return dateValidation;
    }



    public double getRate() {
        return rate;
    }

    public abstract void update();

    public abstract int getUpgradeRate ();

    public void setWaitlist(ArrayList<Reservation> waitlist) {
        this.waitlist = waitlist;
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