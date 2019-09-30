
public class VolunteerPage extends User {

    private String dob;
    private String time;
    private String address;
    private String contact;

    public VolunteerPage(String name, String email, String username, String password, String bio, String dob, String time, String address, String contact) {
        super(name, email, username, password, bio);
        this.dob = dob;
        this.time = time;
        this.address = address;
        this.contact = contact;
    }

    public String getDob() {
        return dob;
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
        return  "VolunteerPage{" +
                super.toString()+
                "dob=" + dob +
                ", time=" + time +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
