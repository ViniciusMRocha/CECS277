public class Professors extends Person {
    private String dept;

    public Professors(String firstName, String lastName, String dept) {
        super(firstName, lastName);
        this.dept = dept;
    }

    public void display () {
        System.out.println("Professor Update " + this.dept );
    }
}
