import javafx.geometry.Pos;

import java.time.LocalDate;
import java.util.*;

public class Tester {

    /**
     * QUESTIONS
     * Should we show same day events?
     *
     */

    public static void main(String[] args) {

        /**
         * Tester variables and other values
         */
        // Variables
        ArrayList<User> allUsers = new ArrayList<User>();
        ArrayList<User> allEvents = new ArrayList<>();
        ArrayList<Post> feed = new ArrayList<Post>();

        // get local time in the machine
        LocalDate t = LocalDate.now();
        Date today = new Date(t.getYear(),t.getMonthValue(),t.getDayOfMonth());


        // Individuals
        Individual jimmy = new Individual("Jimmy","Jimmy.Sparks@gmail.com", "Jimmy.Sparks", "Welc@me!", "Believed in the American way", "1980-05-09", "123-321-1234");
        allUsers.add(jimmy);
        Individual donna = new Individual("Donna","Donna.Sparks@gmail.com", "Donna.Sparks", "Welc@me!", "The trucks always made you worried", "1985-04-21", "123-321-1234");
        allUsers.add(donna);
        Individual gloria = new Individual("Gloria","Gloria.Sparks@gmail.com", "Gloria.Sparks", "Welc@me!", "No one said enough is enough", "2000-06-27", "123-321-1234");
        allUsers.add(gloria);
        Individual junior = new Individual("Junior","Junior.Sparks@gmail.com", "Junior.Sparks", "Welc@me!", "The only normal one probably", "2010-08-11", "123-321-1234");
        allUsers.add(junior);

        // Organizations
        Organization impact = new Organization("Impact","Impact.corp@gmail.com","impact.corp","impact_corp","This company will take us diamond","123 Main","(778)908-7831","192-21-1244","931-129-1284");
        allUsers.add(impact);

        // VolunteerPage
        VolunteerPage philantropy = new VolunteerPage("DSP","dsp@gmail.com","dsp-pl","lambda213","CSULB chapter","1988-05-13","12:00","1250 Belflower", "(556)873-8823");
        allUsers.add(philantropy);
        allEvents.add(philantropy);

        // Test Post
        Post testPost1 = new Post("Post A");
        feed.add(testPost1);
        Post testPost2 = new Post("Same year, Same Month, Same Day","2019-10-09");
        feed.add(testPost2);
        Post testPost3 = new Post("Post B");
        feed.add(testPost3);
        Post testPost4 = new Post("Same year, Same Month, Past Day","2019-10-05");
        feed.add(testPost4);
        Post testPost5 = new Post("Post C");
        feed.add(testPost5);
        Post testPost6 = new Post("Same year, Past Month, Past Day","2019-09-05");
        feed.add(testPost6);
        Post testPost7 = new Post("Post D");
        feed.add(testPost7);
        Post testPost8 = new Post("Past year, Past Month, Past Day","2018-09-05");
        feed.add(testPost8);
        Post testPost9 = new Post("Post E");
        feed.add(testPost9);
        Post testPost10= new Post("Future year, Future Month, Future Day","2020-12-12");
        feed.add(testPost10);
        Post testPost11= new Post("Same year, Future Month, Future Day","2019-12-12");
        feed.add(testPost11);
        Post testPost12= new Post("Same year, Same Month, Future Day","2019-10-15");
        feed.add(testPost12);

        /**
         *  LOGIC START HERE
         */

        // makes the while loop run. It is set to 0 to stop the process
        int stop = 1;

        System.out.println("Welcome to Impact");

        // Do the following while the variable stop has not been set to 0
        do {

        // create a menus
        MenuNav nav = new MenuNav();
        nav.mainMenu();

        // Listener to the option of the main menu
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
                Individual i = new Individual(name,email,username,password,bio,dob,bankAcct);

                allUsers.add(i);
                String iUserName = i.getUsername();
                // Post the new individual username in the feed
                Post newIndividualPost = new Post (iUserName + " is a new individual user. Welcome to impact! ");
                feed.add(newIndividualPost);

            } else if (createOption.equalsIgnoreCase("O")) {
                // add and create a new organization to the list of all users
                /**
                 * Creating individual
                 */
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
                Organization o = new Organization(name,email,username,password,bio,mailing,phone,tax,bankAcct);

                allUsers.add(o);
                String oName = o.getName();
                // Post the new organization name in the feed
                Post newOrganizationPost = new Post (oName + " is a new organization. Welcome to impact! ");
                feed.add(newOrganizationPost);


            } else if (createOption.equalsIgnoreCase("V")) {

                /**
                 * Creating volunteer page
                 */
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
                VolunteerPage v = new VolunteerPage(name,email,username,password,bio,date,time,address,contact);

                allUsers.add(v);
                // add the event to a events arrayList
                allEvents.add(v);
                // post the new event name, location, date and time in the feed
                String vName = v.getName();
                String vAddress = v.getAddress();
                String vDate = v.getDate();
                String vTime = v.getTime();
                Post newVolunteerPagePost = new Post (vName + " is a event available in Impact! Address: "+vAddress+" on "+vDate+" at "+vTime,vDate);
                feed.add(newVolunteerPagePost);

            } else {
                System.out.println("Not a valid option");
            }

         /**
         * The post object could be only a message that is a sting
         */
        } else if (menuChoice.equalsIgnoreCase("A")) {
            System.out.println(" ");
            System.out.println("Select a user to act as: ");
            System.out.println(" ");
            for (int i = 0; i < allUsers.size() ; i++) {
                System.out.println(allUsers.get(i));
            }
            System.out.println(" ");
            System.out.println("Select a user by entering the ID: ");
            // loop for a int here
            int selectedId = Integer.parseInt(scan.nextLine().trim());

            // gets the user name associated with the id selected
            User selectedUser = allUsers.get(selectedId-1);

            System.out.println(" ");
            System.out.println("You selected user: "+ selectedUser.getUsername());

            /**
             * Sub-menu for each of the type of individual
             */
            if (allUsers.get(selectedId-1).getUserType() == "Individual") {
            nav.actAsIndividual();
            } else if (allUsers.get(selectedId-1).getUserType() == "Organization") {
                nav.actAsOrganization();
            } else if (allUsers.get(selectedId-1).getUserType() == "VolunteerPage") {
                nav.actAsEvent();
            } else {
                System.out.println("Not a valid option");
            }

            /**
             * Making a post logic
             */
            String option = scan.nextLine();
            if (option.equalsIgnoreCase("P")){
                System.out.println("Enter a message: ");
                String message = scan.nextLine();
                System.out.println("Do you want to enter a file? (Y/N)");
                String fileQuestion = scan.nextLine();
                if (fileQuestion.equalsIgnoreCase("Y")) {
                    System.out.println("Enter a file: ");
                    String file = scan.nextLine();
                    // create message with file
                    String msgP = selectedUser.getUsername() + " posted: " + message + "and a file: " +file;
                    Post newPost = new Post (msgP);
                    feed.add(newPost);
                } else if (fileQuestion.equalsIgnoreCase("N")){
                    // create message without file
                    String msgP = selectedUser.getUsername() + " posted: " + message;
                    Post newPost = new Post (msgP);
                    feed.add(newPost);
                } else {
                    System.out.println("Not a valid option");
                }


            } else if (option.equalsIgnoreCase("M")){
                System.out.println("Making an event");

            } else if (option.equalsIgnoreCase("R")){
                System.out.println("Registering for a event");
                // get a list of all the events
                for (int i = 0; i < allEvents.size(); i++) {
                    int j = i +1 ;
                    System.out.println("Option: "+j+" Event Name: "+allEvents.get(i).getName());
                }

                // ask the user what event they want to register using the ID
                System.out.println(" ");
                System.out.println("Select a event by entering the ID: ");
                // loop for a int here
                int selectedEventId = Integer.parseInt(scan.nextLine().trim());

                User selectedEvent = allEvents.get(selectedEventId-1);
                System.out.println("Event Selected: "+selectedEvent.getName());

                // create message
                String msgR = selectedUser.getUsername() + " has registered to " + selectedEvent.getName();
                // make a new post object
                Post newRegistration = new Post (msgR);
                // add the new post object to the feed
                feed.add(newRegistration);
                System.out.println("User "+selectedUser.getUsername()+" is registered to "+selectedEvent.getName());

            } else if (option.equalsIgnoreCase("E")){
                System.out.println("Returning to the main menu");

            } else {
                System.out.println("Not a valid option");

            }

        /**
         * Display the feed
         */
        } else if (menuChoice.equalsIgnoreCase("D")) {
        System.out.println("Displaying Feed");
        for (int i = 0; i < feed.size(); i++) {
            if ( feed.get(i).getDate() == null) {
                System.out.println(feed.get(i));
            } else {
                // get date of the post
                int pYear = feed.get(i).getYear();
                int pMonth = feed.get(i).getMonth();
                int pDay = feed.get(i).getDay();
                // set year, month and date to variables
                Date dateToCompare = new Date(pYear, pMonth,pDay);
                // put the into the comparison object
                int result = dateToCompare.compareTo(today);
                if (result == 1 ) {
                    System.out.println(feed.get(i));
                } else if (result == 0) {
                    System.out.println(feed.get(i));
                }

            }

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
