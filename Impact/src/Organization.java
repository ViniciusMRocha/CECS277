public class Organization extends User {

    private String mailing;
    private String phone;
    private  String tax;
    private String bankAcct;

    public Organization(String name, String email, String username, String password, String bio, String mailing, String phone, String tax, String bankAcct) {
        super(name, email, username, password, bio);
        this.mailing = mailing;
        this.phone = phone;
        this.tax = tax;
        this.bankAcct = bankAcct;
    }

    public String getMailing() {
        return mailing;
    }

    public String getPhone() {
        return phone;
    }

    public String getTax() {
        return tax;
    }

    public String getBankAcct() {
        return bankAcct;
    }

    @Override
    public String toString() {
        return "Organization{" +
                super.toString() +
                "mailing='" + mailing + '\'' +
                ", phone='" + phone + '\'' +
                ", tax='" + tax + '\'' +
                ", bankAcct='" + bankAcct + '\'' +
                '}';
    }


}