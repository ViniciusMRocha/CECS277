public class Customer {
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

    public Customer(String name, String email) {
        idGenerator++;
        this.id = idGenerator;
        this.name = name;
        this.address = null;
        this.phone = null;
        this.email = email;
        this.ccNumber = null;
        this.ccName = null;
        this.ccDate = null;
        this.ccSecurity = null;
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
    }

    /**
     * Interface Methods
     */

    public void update() {

    }

    public int getId() {
        return id;
    }

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

// name, address, phone number, email, credit card info
//name on card, number, exp.