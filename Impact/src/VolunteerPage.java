
public class VolunteerPage extends User {

    private String date;
    private String time;
    private String address;
    private String contact;

    public VolunteerPage(String name, String email, String username, String password, String bio, String date, String time, String address, String contact) {
        super(name, email, username, password, bio,"VolunteerPage");
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

    public int getYear () {
        String strYear = date.substring(0,4);
        int intYear = Integer.parseInt(strYear);
        return intYear;
    }
    public int getMonth () {
        String strMonth = date.substring(5,7);
        int intMonth = Integer.parseInt(strMonth);
        return intMonth;
    }
    public int getDay () {
        String strDay = date.substring(8,10);
        int intDay = Integer.parseInt(strDay);
        return intDay;
    }

    @Override
    public String toString() {
        return super.toString() +
            "date='" + date + '\'' +
            ", time='" + time + '\'' +
            ", address='" + address + '\'' +
            ", contact='" + contact + '\''
            ;
    }

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
