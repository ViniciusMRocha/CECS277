public class Tester {

    public static void printDisplay (Person p) {
        p.display();
    }

    public static void main(String[] args) {
        System.out.println("Testing Person");

        Student s = new Student("Vini", "Rocha","Senior");
        Professors p = new Professors("James","Bond","CECS277");

        printDisplay(s);
        printDisplay(p);



    }
}
