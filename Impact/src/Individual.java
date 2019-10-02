import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;


public class Individual extends User{
    private static String type = "individual";
    private String dob;
    private String bankAcct;
    private String userType;

    public Individual(String name, String email, String username, String password, String bio, String dob, String bankAcct) {

        super(name, email, username, password, bio);
        this.dob = dob;
        this.bankAcct = bankAcct;
        this.userType = type;
        /**
         * set to optional
         */

    }

    public String getDob() {
        return dob;
    }

    public String getBankAcct() {
        return bankAcct;
    }





    @Override
    public String toString() {
        return  super.toString()+
                "dob=" + dob +
                ", bankAcct='" + bankAcct + '\'' +
                '}';
    }
}

