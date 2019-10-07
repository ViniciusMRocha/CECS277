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


    public String actAsIndividual() {
        Scanner scan = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("What do you want to do as the individual");
        System.out.println("P) Post Update");
        System.out.println("M) Make Donation");
        System.out.println("R) Register for Event");
        System.out.println("E) Exit to main");
        System.out.println(" ");
        String option = scan.nextLine();

        if (option.equalsIgnoreCase("P")){
            return "P";
        } else if (option.equalsIgnoreCase("M")){
            return "M";
        } else if (option.equalsIgnoreCase("R")){
            return "R";
        } else if (option.equalsIgnoreCase("E")){
            return "E";
        } else {
            return "Not a valid option";
        }

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

