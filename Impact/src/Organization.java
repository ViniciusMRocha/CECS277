public class Organization extends User {

    private String mailing;
    private String phone;
    private String tax;
    private String bankAcct;

    /**
     * Creates a organization type of user with the following attributes
     * @param name String
     * @param email String
     * @param username String
     * @param password String
     * @param bio String
     * @param mailing String
     * @param phone String
     * @param tax String
     * @param bankAcct String
     */
    public Organization(String name, String email, String username, String password, String bio, String mailing, String phone, String tax, String bankAcct) {
        super(name, email, username, password, bio, "Organization");
        this.mailing = mailing;
        this.phone = phone;
        this.tax = tax;
        this.bankAcct = bankAcct;
    }

    /**
     * Returns the organization's mailing address
     * @return String
     */
    public String getMailing() {
        return mailing;
    }

    /**
     * Returns the organization's phone number
     * @return String
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Returns the organization's tax id
     * @return String
     */
    public String getTax() {
        return tax;
    }

    /**
     * Returns the organization's bank account number
     * @return String
     */
    public String getBankAcct() {
        return bankAcct;
    }

    /**
     * prints the organization's attributes
     * @return String
     */
    @Override
    public String toString() {
        return  super.toString() +
                "mailing='" + mailing + '\'' +
                ", phone='" + phone + '\'' +
                ", tax='" + tax + '\'' +
                ", bankAcct='" + bankAcct + '\''
                ;
    }

    /**
     * prints the organization's information
     */
    public void display(){
        super.display();
        String mailing = getMailing();
        String phone = getPhone();
        String tax = getTax();
        String bankAcct = getBankAcct();
        System.out.println(
            ", mailing='" + mailing + '\'' +
            ", phone='" + phone + '\'' +
            ", tax='" + tax + '\'' +
            ", bankAcct='" + bankAcct + '\'' +
            " "
        );

    }

}
