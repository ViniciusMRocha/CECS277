public class Individual extends User{
    private static String type = "individual";
    private String dob;
    private String bankAcct;
    private String userType;

    /**
     * Creates a Individual type of user with the following attributes
     * @param name String
     * @param email String
     * @param username String
     * @param password String
     * @param bio String
     * @param dob String
     * @param bankAcct String
     */
    public Individual(String name, String email, String username, String password, String bio, String dob, String bankAcct) {

        super(name, email, username, password, bio, "Individual");
        this.dob = dob;
        this.bankAcct = bankAcct;
        this.userType = type;
    }

    /**
     * Creates a individual type of user with the following attributes
     * @param name String
     * @param email String
     * @param username String
     * @param password String
     * @param bio String
     * @param dob String
     */
    public Individual(String name, String email, String username, String password, String bio, String dob) {

        super(name, email, username, password, bio, "Individual");
        this.dob = dob;
        this.userType = type;
    }

    /**
     * Returns the individual's date of birth
     * @return String
     */
    public String getDob() {
        return dob;
    }

    /**
     * Returns the individual's bank account number
     * @return String
     */
    public String getBankAcct() {
        return bankAcct;
    }

    /**
     * Returns the year that the individual was born, by taking the substring from the DOB
     * @return int
     */
    public int getYear () {
        String strYear = dob.substring(0,4);
        int intYear = Integer.parseInt(strYear);
        return intYear;
    }

    /**
     * Returns the month that the individual was born, by taking the substring from the DOB
     * @return int
     */
    public int getMonth () {
        String strMonth = dob.substring(5,7);
        int intMonth = Integer.parseInt(strMonth);
        return intMonth;
    }

    /**
     * Returns the day that the individual was born, by taking the substring from the DOB
     * @return int
     */
    public int getDay () {
        String strDay = dob.substring(8,10);
        int intDay = Integer.parseInt(strDay);
        return intDay;
    }

    /**
     * Update the individual's bank account
     * @param bankAcct String
     */
    public void setBankAcct(String bankAcct) {
        this.bankAcct = bankAcct;
    }

    /**
     * prints the individual's information
     */
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

    /**
     * prints the individual attributes
     * @return String
     */
    @Override
    public String toString() {
        return  super.toString() +
                "dob='" + dob + '\'' +
                ", bankAcct='" + bankAcct + '\'' +
                ", userType='" + userType + '\''
                ;
    }
}

