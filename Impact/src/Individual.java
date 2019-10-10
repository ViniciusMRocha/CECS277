import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;


public class Individual extends User{
    private static String type = "individual";
    private String dob;
    private String bankAcct;
    private String userType;

    public Individual(String name, String email, String username, String password, String bio, String dob, String bankAcct) {

        super(name, email, username, password, bio, "Individual");
        this.dob = dob;
        this.bankAcct = bankAcct;
        this.userType = type;
    }

    public String getDob() {
        return dob;
    }

    public String getBankAcct() {
        return bankAcct;
    }

    public int getYear () {
        String strYear = dob.substring(0,4);
        int intYear = Integer.parseInt(strYear);
        return intYear;
    }
    public int getMonth () {
        String strMonth = dob.substring(5,7);
        int intMonth = Integer.parseInt(strMonth);
        return intMonth;
    }
    public int getDay () {
        String strDay = dob.substring(8,10);
        int intDay = Integer.parseInt(strDay);
        return intDay;
    }

    public void display(){
       super.display();
       String dob = getDob();
       String bankAcct = getBankAcct();
       String userType = getUserType();
       System.out.println(
            "dob=" + dob +
            ", bankAcct='" + bankAcct + '\'' +
            ", userType='" + userType + '\'' +
            " "
        );
    }

    @Override
    public String toString() {
        return  super.toString() +
                "dob='" + dob + '\'' +
                ", bankAcct='" + bankAcct + '\'' +
                ", userType='" + userType + '\''
                ;
    }
}

