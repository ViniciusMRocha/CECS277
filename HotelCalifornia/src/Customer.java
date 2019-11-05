public class Customer{
    private static int idGenerator = 0;
    private int id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String ccNumber;
    private String ccName;
    private String ccDate;
    private String ccSecurity;

    /**
     * Creates a customer with basic personal information and credit card information
     * @param name String
     * @param address String
     * @param phone String
     * @param email String
     * @param ccNumber String
     * @param ccName String
     * @param ccDate String
     * @param ccSecurity String
     */
    public Customer(String name, String address, String phone, String email, String ccNumber, String ccName, String ccDate, String ccSecurity) {
        idGenerator++;
        this.id = idGenerator;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.ccNumber = ccNumber;
        this.ccName = ccName;
        this.ccDate = ccDate;
        this.ccSecurity = ccSecurity;
    }

  // Class Methods


    /**
     * Prints the customer attributes
     * @return String
     */
    @Override
    public String toString() {
        return "Customer      {" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' + "}\n" +
                "     Card Info     {" +
                "ccNumber='" + ccNumber + '\'' +
                ", ccName='" + ccName + '\'' +
                ", ccDate='" + ccDate + '\'' +
                ", ccSecurity='" + ccSecurity + '\'' +
                "}";
    }
}