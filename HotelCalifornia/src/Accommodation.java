import java.util.ArrayList;

public interface Accommodation {

    /**
     * Abstract method for attaching a reservation to a room
     * @param reservation Reservation
     */
    void addReserve(Reservation reservation);

    /**
     * Abstract method for detach a reservation from a room and delete it
     * @param reservation Reservation
     */
    void removeReserve(Reservation reservation);

    /**
     * Abstract method for when a reservation is canceled the room gets notify and goes over the waitlist to try to add a new reservation to the room
     * @param reservation
     */
    void notification(Reservation reservation, ArrayList<Reservation> allReservations);

}
