import javax.sound.midi.Soundbank;
import java.util.*;

public class Tester {

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
        ArrayList<Post> feed = new ArrayList<Post>();

        // Individuals
        Individual jimmy = new Individual("Jimmy","Jimmy.Sparks@gmail.com", "Jimmy.Sparks", "Welc@me!", "Jimmy Sparks belived in the American way", "2019-01-01", "123-321-1234");
        allUsers.add(jimmy);

        // Organizations
        Organization impact = new Organization("Impact","Impact.corp@gmail.com","impact.corp","impact_corp","This company will take us diamond","123 Main","(778)908-7831","192-21-1244","931-129-1284");
        allUsers.add(impact);

        // VolunteerPage
        VolunteerPage philantropy = new VolunteerPage("DSP","dsp@gmail.com","dsp-pl","lambda213","CSULB chapter","1988-05-13","12:00","1250 Belflower", "(556)873-8823");
        allUsers.add(philantropy);

        // Post
        Post testPost = new Post("Username","Test Message","c:/photos");
        feed.add(testPost);

        int stop = 1;

        System.out.println("Welcome to Impact");


        do {

        MenuNav nav = new MenuNav();
        nav.mainMenu();

        Scanner scan = new Scanner(System.in);
        System.out.println("Option: ");
        String menuChoice = scan.nextLine();

            /**
             * Create a user
             */
            if (menuChoice.equalsIgnoreCase("C")) {
            nav.createMenu();
            String createOption = scan.nextLine();

            if (createOption.equalsIgnoreCase("I")) {
                // add and create a new individual to the list of all users
                allUsers.add(createIndividual());
            } else if (createOption.equalsIgnoreCase("O")) {
                // add and create a new organization to the list of all users
                allUsers.add(createOrganization());
            } else if (createOption.equalsIgnoreCase("V")) {
                // add and create a new volunteer to the list of all users
                allUsers.add(createVolunteerPage());
            }

         /**
         * Act as a user
         */
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
            User selectedUser = allUsers.get(selectedId-1);
            System.out.println(selectedUser);
                System.out.println(selectedUser.getUsername());

            if (allUsers.get(selectedId-1).getUserType() == "Individual") {
                nav.actAsIndividual();
            } else if (allUsers.get(selectedId-1).getUserType() == "Organization") {
                nav.actAsOrganization();
            } else if (allUsers.get(selectedId-1).getUserType() == "VolunteerPage") {
                nav.actAsEvent();
            } else {
                System.out.println("Not a valid option");
            }

            String option = scan.nextLine();
            if (option.equalsIgnoreCase("P")){
                System.out.println("Enter a message: ");
                String message = scan.nextLine();
                System.out.println("Enter a file: ");
                String file = scan.nextLine();
                Post newPost = new Post (selectedUser.getUsername(),message,file);
                feed.add(newPost);

            } else if (option.equalsIgnoreCase("M")){
                System.out.println("M");

            } else if (option.equalsIgnoreCase("R")){
                System.out.println("R");

            } else if (option.equalsIgnoreCase("E")){
                System.out.println("E");

            } else {
                System.out.println("Not a valid option");

            }

        /**
         * Display the feed
         */
        } else if (menuChoice.equalsIgnoreCase("D")) {
        System.out.println("Displaying Feed");
        for (int i = 0; i < feed.size(); i++) {
            System.out.println(feed.get(i));
        }

        /**
         * Quit Impact
         */
        } else if (menuChoice.equalsIgnoreCase("Q")) {
            System.out.println("Closing Impact");
            stop = 0;
        }

        else {
            System.out.println("Not a valid choice, Try again");
        }

        }
        // kills the application
        while (stop == 1);
    }
}
