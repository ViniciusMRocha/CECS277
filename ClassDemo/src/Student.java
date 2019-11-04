public class Student extends Person {
    private String grade;

    public Student(String firstName, String lastName, String grade) {
        super(firstName, lastName);
        this.grade = grade;
    }

    public void display() {
        System.out.println("Student Update " + this.grade);

    }

}
