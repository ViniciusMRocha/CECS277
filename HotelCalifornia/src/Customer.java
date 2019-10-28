public class Customer {
    private static int idGenerator = 0;
    private int id;
    private String name;
    private String email;

    public Customer(String name, String email) {
        idGenerator++;
        this.id = idGenerator;
        this.name = name;
        this.email = email;
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
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
