import java.util.Scanner;

public class MenuNav {
    public MenuNav() {
    }
    public void mainMenu() {
        System.out.println(" ");
        System.out.println("Main menu");
        System.out.println(" ");
        System.out.println("Please select one of the following");
        System.out.println("C) Create new user");
        System.out.println("A) Act as a user");
        System.out.println("D) Display feed");
        System.out.println("Q) Quit");
        System.out.println(" ");

    }

    public void createMenu() {
        System.out.println(" ");
        System.out.println("Creating new user");
        System.out.println("What kind of user do you want to create?");
        System.out.println("I) Individual");
        System.out.println("O) Organization");
        System.out.println("V) Volunteer");
        System.out.println(" ");

    }

    public void actAsIndividual() {
        System.out.println(" ");
        System.out.println("What do you want to do as the individual");
        System.out.println("P) Post Update");
        System.out.println("M) Make Donation");
        System.out.println("R) Register for Event");
        System.out.println("E) Exit to main");
        System.out.println(" ");

    }

    public void actAsEvent() {
        System.out.println(" ");
        System.out.println("What do you want to do to the event");
        System.out.println("P) Post Update");
        System.out.println("M) Modify Date / Time / Location");
        System.out.println("E) Exit to main");
        System.out.println(" ");
    }

    public void actAsOrganization() {
        System.out.println(" ");
        System.out.println("What do you want to do an organization");
        System.out.println("P) Post Update");
        System.out.println("E) Exit to main");
        System.out.println(" ");
    }
}
