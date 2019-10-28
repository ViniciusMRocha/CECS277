public interface Accomodation {

    void addPatron(Customer customer);

    void removePatron(Customer customer);

    // look for the next patron and make it a room
    void notification();


}
