import java.util.ArrayList;

public interface Accomodation {

    void addReserve(Reservation reservation);

    void removeReserve(Reservation reservation);

    // look for the next patron and make it a room
    void notification(Reservation reservation);

}
