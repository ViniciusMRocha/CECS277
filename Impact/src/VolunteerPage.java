
public class VolunteerPage extends User {

    private String date;
    private String time;
    private String address;
    private String contact;

    public VolunteerPage(String name, String email, String username, String password, String bio, String date, String time, String address, String contact) {
        super(name, email, username, password, bio);
        this.date = date;
        this.time = time;
        this.address = address;
        this.contact = contact;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return  super.toString()+
                "date=" + date +
                ", time=" + time +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
