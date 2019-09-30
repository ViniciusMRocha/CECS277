import java.util.Date;
import java.text.SimpleDateFormat;

public class Individual extends User{
    private String dob;
    private String bankAcct;

    public Individual(String name, String email, String username, String password, String bio, String dob, String bankAcct) {

//        https://www.guru99.com/java-date.html

        super(name, email, username, password, bio);
        this.dob = dob;
        this.bankAcct = bankAcct;
    }

    public String getDob() {
        return dob;
    }

    public String getBankAcct() {
        return bankAcct;
    }

    @Override
    public String toString() {
        return "Individual{" +
                super.toString()+
                "dob=" + dob +
                ", bankAcct='" + bankAcct + '\'' +
                '}';
    }
}

