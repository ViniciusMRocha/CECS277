import javax.sound.midi.Soundbank;
import java.util.*;

public class Tester {

    public static User createUser() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Name: ");
        String name = scan.nextLine();
        System.out.println("Enter Email: ");
        String email = scan.nextLine();
        System.out.println("Enter Username: ");
        String username = scan.nextLine();
        System.out.println("Enter Password: ");
        String password = scan.nextLine();
        System.out.println("Enter Bio: ");
        String bio = scan.nextLine();

        return new User(name,email,username,password,bio);
    }

    public static User createIndividual() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Name: ");
        String name = scan.nextLine();
        System.out.println("Enter Email: ");
        String email = scan.nextLine();
        System.out.println("Enter Username: ");
        String username = scan.nextLine();
        System.out.println("Enter Password: ");
        String password = scan.nextLine();
        System.out.println("Enter Bio: ");
        String bio = scan.nextLine();
        System.out.println("Enter Date of Birth: ");
        String dob = scan.nextLine();
        System.out.println("Enter Bank Account: ");
        String bankAcct = scan.nextLine();

        return new Individual(name,email,username,password,bio,dob,bankAcct);
    }


    public static User createOrganization() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Name: ");
        String name = scan.nextLine();
        System.out.println("Enter Email: ");
        String email = scan.nextLine();
        System.out.println("Enter Username: ");
        String username = scan.nextLine();
        System.out.println("Enter Password: ");
        String password = scan.nextLine();
        System.out.println("Enter Bio: ");
        String bio = scan.nextLine();
        System.out.println("Enter Mailing: ");
        String mailing = scan.nextLine();
        System.out.println("Enter Phone: ");
        String phone = scan.nextLine();
        System.out.println("Enter Tax ID: ");
        String tax = scan.nextLine();
        System.out.println("Enter Bank Account: ");
        String bankAcct = scan.nextLine();

        return new Organization(name,email,username,password,bio,mailing,phone,tax,bankAcct);
    }

    public static User createVolunteerPage() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Name: ");
        String name = scan.nextLine();
        System.out.println("Enter Email: ");
        String email = scan.nextLine();
        System.out.println("Enter Username: ");
        String username = scan.nextLine();
        System.out.println("Enter Password: ");
        String password = scan.nextLine();
        System.out.println("Enter Bio: ");
        String bio = scan.nextLine();
        System.out.println("Enter Date: ");
        String date = scan.nextLine();
        System.out.println("Enter Time: ");
        String time = scan.nextLine();
        System.out.println("Enter Address: ");
        String address = scan.nextLine();
        System.out.println("Enter Contact: ");
        String contact = scan.nextLine();

        return new VolunteerPage(name,email,username,password,bio,date,time,address,contact);
    }

    public static void main(String[] args) {

        // Variables
        ArrayList<User> allUsers = new ArrayList<User>();
        ArrayList<String> feed = new ArrayList<String>();

        // Individuals
        Individual jimmy = new Individual("Jimmy","Jimmy.Sparks@gmail.com", "Jimmy.Sparks", "Welc@me!", "Jimmy Sparks belived in the American way", "2019-01-01", "123-321-1234");
        allUsers.add(jimmy);

        // Organizations
        Organization impact = new Organization("Impact","Impact.corp@gmail.com","impact.corp","impact_corp","This company will take us diamond","123 Main","(778)908-7831","192-21-1244","931-129-1284");
        allUsers.add(impact);

        // VolunteerPage
        VolunteerPage philantropy = new VolunteerPage("DSP","dsp@gmail.com","dsp-pl","lambda213","CSULB chapter","1988-05-13","12:00","1250 Belflower", "(556)873-8823");
        allUsers.add(philantropy);

        System.out.println("Welcome to Impact");

        MenuNav nav = new MenuNav();
        nav.mainMenu();

        Scanner scan = new Scanner(System.in);
        System.out.println("Option: ");
        String menuChoice = scan.nextLine();

        if (menuChoice.equalsIgnoreCase("C")) {
            nav.createMenu();
            String createOption = scan.nextLine();

            if (createOption.equalsIgnoreCase("I")) {
                createIndividual();
            } else if (createOption.equalsIgnoreCase("O")) {
                createOrganization();
            } else if (createOption.equalsIgnoreCase("V")) {
                createVolunteerPage();
            }

        } else if (menuChoice.equalsIgnoreCase("A")) {
            System.out.println(" ");
            System.out.println("Select a user to act as: ");
            System.out.println(" ");
            for (int i = 0; i < allUsers.size() ; i++) {
                System.out.println(allUsers.get(i));
            }
            System.out.println(" ");
            System.out.println("Select a user by entering a ID: ");
            int selectedId = Integer.parseInt(scan.nextLine().trim());

            System.out.println(" ");
            System.out.println("You selected: "+selectedId);
            System.out.println(allUsers.get(selectedId-1));
            nav.actAsIndividual();

            //Do I need a new scanner here?
            String actOption = scan.nextLine();

            if(actOption.equalsIgnoreCase("P")) {
                System.out.println("You selected Post Update");
            } else if (actOption.equalsIgnoreCase("M")) {
                System.out.println("Make Donation");
            } else if (actOption.equalsIgnoreCase("R")) {
                System.out.println("Register for Event");
            } else {
                System.out.println("Not a valid message");
            }

        } else if ( menuChoice.equalsIgnoreCase("D")) {
            System.out.println("User picker D");
            System.out.println("Displaying Feed");
            for (int i = 0; i < feed.size(); i++) {
                System.out.println(feed.get(i));
            }

        } else {
            System.out.println("Not a valid choice, Try again");
        }




//        System.out.println("User");
//        User newUser = createUser();
//        allUsers.add(newUser);
//        System.out.println(newUser.toString());
//
//        System.out.println("Individuals");
//        User newIndividual = createIndividual();
//        System.out.println(newIndividual.toString());
//
//        System.out.println("Organization");
//        User newOrganization = createOrganization();
//        System.out.println(newOrganization.toString());
//
//        System.out.println("Volunteer");
//        User newVolunteerPage = createVolunteerPage();
//        System.out.println(newVolunteerPage.toString());

    }
}
