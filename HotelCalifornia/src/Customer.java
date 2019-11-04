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
//    private boolean confirmedCustomer;

    // TODO: delete after development is done. It is used for test data
    public Customer(String name, String email) {
        idGenerator++;
        this.id = idGenerator;
        this.name = name;
        this.email = email;
    }

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
//        this.confirmedCustomer= false;

    }



//       public boolean update() {
//        // add a scanner to to decided if the customer wants to be added
//           // if YES change the confirmed customer variable to true
//           this.confirmedCustomer = true;
//           return confirmedCustomer;
//       }

    /**
     * Other methods
     *
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