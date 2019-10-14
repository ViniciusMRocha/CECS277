
public class VolunteerPage extends User {

    private String date;
    private String time;
    private String address;
    private String contact;
    private int attendees;

    /**
     * Creates a Volunteer Page type of user with the following attributes
     * @param name String
     * @param email String
     * @param username String
     * @param password String
     * @param bio String
     * @param date String
     * @param time String
     * @param address String
     * @param contact String
     */
    public VolunteerPage(String name, String email, String username, String password, String bio, String date, String time, String address, String contact) {
        super(name, email, username, password, bio,"VolunteerPage");
        this.date = date;
        this.time = time;
        this.address = address;
        this.contact = contact;
        this.attendees = 0;
    }

    /**
     * Returns the event's date
     * @return String
     */
    public String getDate() {
        return date;
    }

    /**
     * Returns the event's time
     * @return String
     */
    public String getTime() {
        return time;
    }

    /**
     * Returns the event's address
     * @return String
     */
    public String getAddress() {
        return address;
    }

    /**
     * Returns the event's contact info
     * @return String
     */
    public String getContact() {
        return contact;
    }

    /**
     * Returns the event's attendees count
     * @return Int
     */
    public int getAttendees() { return attendees; }

    /**
     * Add one more attendee in the attendee count of the event
     */
    public void addAttendees() {
        this.attendees++;
    }

    /**
     * Returns the year that the event happens
     * @return Int
     */
    public int getYear () {
        String strYear = date.substring(0,4);
        int intYear = Integer.parseInt(strYear);
        return intYear;
    }

    /**
     * Returns the month that the event happens
     * @return Int
     */
    public int getMonth () {
        String strMonth = date.substring(5,7);
        int intMonth = Integer.parseInt(strMonth);
        return intMonth;
    }

    /**
     * Returns the day that the event happens
     * @return Int
     */
    public int getDay () {
        String strDay = date.substring(8,10);
        int intDay = Integer.parseInt(strDay);
        return intDay;
    }

    /**
     * Update the date of the event
     * @param date String
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Update the time of the event
     * @param time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Update the address of the event
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }


    /**
     * prints the event's attributes
     * @return String
     */
    @Override
    public String toString() {
        return super.toString() +
            "date='" + date + '\'' +
            ", time='" + time + '\'' +
            ", address='" + address + '\'' +
            ", contact='" + contact + '\''
            ;
    }

    /**
     * prints the event's information
     */
    public void display() {
        super.display();
        String date = getDate();
        String time = getTime();
        String address = getAddress();
        String contact = getContact();
        System.out.println(
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                " "
        );


    };

}
