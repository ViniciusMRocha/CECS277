import java.time.LocalDate;
import java.util.*;

public class Tester {


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
        Date today = new Date(t.getYear(),t.getMonthValue()-1,t.getDayOfMonth());
        Date eighteen = new Date(t.getYear()-18,t.getMonthValue()-1,t.getDayOfMonth());

        // Individuals
        Individual jane = new Individual("Jane Doe","jdoe@csulb.edu", "SerengetiJane", "XxX123", "Biology major @CSULB. Lover of the outdoors and anything creepy crawly.", "1997-08-16");
            allUsers.add(jane);
        Individual mateo = new Individual("Mateo Stevens","mathmatt03@gmail.com", "MathMatt", "fortniteislifejk", "Books, pizza, and camping trips please.", "2005-05-03");
            allUsers.add(mateo);

        // Organizations
        Organization wwf = new Organization("World Wide Fund for Nature","wwf@gmail.com","WWF","1234","Working to conserve nature and reduce the most pressing threats to the diversity of life on Earth.","1250 24th Street, N.W. Washington, DC 20037","(202) 293-4800","52-1693387","1234 5678 9012");
            allUsers.add(wwf);
        Organization gsUsa = new Organization("Girl Scouts of the USA","gsusa@gmail.com","GirlScoutsUSA","12345","Oﬀering the best leadership development experience for girls in the world.","420 Fifth Avenue at 37th Street – Ground Floor","(800) 478-7248","13-1624016","9999 0000 1111 2222");
        allUsers.add(gsUsa);

        // VolunteerPage
        VolunteerPage sealBeach = new VolunteerPage("Seal Beach Clean-Up","saveSealBeach@gmail.com","SealBeachCleanUp","sSBcup","A group of caring neighbors looking out for our beaches.","2019-10-13","9am - Noon","Seal Beach Municipal Pier, Old Towne, CA 90740", "(562) 555-5555");
            allUsers.add(sealBeach);
            allEvents.add(sealBeach);


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

                Individual i = new Individual(name,email,username,password,bio,dob);

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

            String option = scan.nextLine();

                /**
                 * Making a POST logic
                 */
            if (option.equalsIgnoreCase("P")){
                System.out.println("Enter a message: ");
                String message = scan.nextLine();
                System.out.println("Do you want to enter a file? (Y/N)");
                String fileQuestion = scan.nextLine();
                if (fileQuestion.equalsIgnoreCase("Y")) {
                    System.out.println("Enter a file: ");
                    String file = scan.nextLine();
                    // create message with file
                    if (selectedUser.getUserType() == "VolunteerPage") {
                        VolunteerPage volunteerPageSelected = (VolunteerPage) selectedUser;
                        String msgP = volunteerPageSelected.getUsername() + " posted: " + message + " and a file: " +file;
                        Post newPostDate = new Post (msgP,volunteerPageSelected.getDate());
                        feed.add(newPostDate);

                    } else {
                        String msgP = selectedUser.getUsername() + " posted: " + message + "and a file: " +file;
                        Post newPost = new Post (msgP);
                        feed.add(newPost);
                    }

                } else if (fileQuestion.equalsIgnoreCase("N")){
                    if (selectedUser.getUserType() == "VolunteerPage") {
                        VolunteerPage volunteerPageSelected = (VolunteerPage) selectedUser;
                        String msgP = volunteerPageSelected.getUsername() + " posted: " + message;
                        Post newPostDate = new Post (msgP,volunteerPageSelected.getDate());
                        feed.add(newPostDate);

                    } else {
                        String msgP = selectedUser.getUsername() + " posted: " + message;
                        Post newPost = new Post (msgP);
                        feed.add(newPost);
                    }
                } else {
                    System.out.println("Not a valid option");
                }

            /**
             * Handle option M
             */
            } else if (option.equalsIgnoreCase("M")){
                /**
                 * Make a donation
                 */
                if (selectedUser.getUserType()=="Individual"){
                    // get user DOB
                    Individual individualSelected = (Individual) selectedUser;

                    int Year = individualSelected.getYear();
                    int Month = individualSelected.getMonth();
                    int Day = individualSelected.getDay();

                    Date dateToCompare = new Date(Year, Month,Day);
                    // put the into the comparison object
                    // compare to today
                    int result = dateToCompare.compareTo(eighteen);

                    //future
                    if (result == 1 ) {
                        System.out.println("Sorry, you are under 18 years old. You cannot make a donation");
                    }
                    // same day
                    else if (result <= 0) {
                        System.out.println("Making a donation");
                        if (individualSelected.getBankAcct() == null) {
                            System.out.println("You do not have a bank account. Please enter one to make a donation");
                            System.out.println("Bank Account: ");
                            String bankAcct = scan.nextLine();
                            individualSelected.setBankAcct(bankAcct);
                            individualSelected.display();
                        }
                        // ask what event they want to donate to
                        System.out.println("Pick an event");

                        // get a list of all the events
                        for (int i = 0; i < allEvents.size(); i++) {
                            int j = i +1 ;
                            System.out.println("Option: "+j+" Event Name: "+allEvents.get(i).getName());
                        }

                        // ask the user what event they want to register using the ID
                        System.out.println(" ");
                        System.out.println("Select an event to donate to: ");

                        // loop for a int here
                        int selectedEventId = Integer.parseInt(scan.nextLine().trim());

                        VolunteerPage selectedEvent = (VolunteerPage) allEvents.get(selectedEventId-1);
                        System.out.println("Event Selected: "+selectedEvent.getName());

                        // ask how much
                        System.out.println(" ");
                        System.out.println("How much do you want to donate? ");
                        String donation = scan.nextLine();

                        // display confirmation message
                        System.out.println("Donation Recorded");

                        // posting to the feed
                        Post post = new Post (selectedUser.getUsername() + " has just donated $"+donation+" to "+selectedEvent.getName());
                        feed.add(post);
                    }

                }
                /**
                /**
                 * Modify date/time/location
                 */
                else if(selectedUser.getUserType()=="VolunteerPage"){
                    VolunteerPage volunteerPageSelected = (VolunteerPage) selectedUser;

                    //new date
                    System.out.println("Enter New Date: ");
                    String newDate = scan.nextLine();
                    if(newDate.isEmpty()){
                        System.out.println("No change");
                    } else {
                        volunteerPageSelected.setDate(newDate);
                    }

                    //new time
                    System.out.println("Enter New Time");
                    String newTime = scan.nextLine();
                    if(newTime.isEmpty()){
                        System.out.println("No change");
                    } else {
                        volunteerPageSelected.setTime(newTime);
                    }

                    //new address
                    System.out.println("Enter New Address");
                    String newAddress = scan.nextLine();
                    if(newAddress.isEmpty()){
                        System.out.println("No change");
                    } else {
                        volunteerPageSelected.setAddress(newAddress);
                    }

                    Post newPost = new Post(volunteerPageSelected.getUsername()+" has been updated. Here is the new info: "+volunteerPageSelected.getAddress()+" on "+volunteerPageSelected.getDate()+" at "+volunteerPageSelected.getTime(),volunteerPageSelected.getDate());
                    feed.add(newPost);
                }
                else{
                    System.out.println("Not a valid option");
                }

            }
            /**
             * Register for an event
             */
            else if (option.equalsIgnoreCase("R") && selectedUser.getUserType()=="Individual"){
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

                VolunteerPage selectedEvent = (VolunteerPage) allEvents.get(selectedEventId-1);
                System.out.println("Event Selected: "+selectedEvent.getName());

                // make a new post object
                Post newRegistration = new Post (selectedUser.getUsername() + " has registered to " + selectedEvent.getName());
                // add the new post object to the feed
                feed.add(newRegistration);
                System.out.println("User "+selectedUser.getUsername()+" is registered to "+selectedEvent.getName());

                // post the registration count
                selectedEvent.addAttendees();
                Post registrationCount = new Post ("'"+selectedEvent.getName() + "' now has " +selectedEvent.getAttendees()+" registered volunteers. Please join us!");
                feed.add(registrationCount);

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
                int Year = feed.get(i).getYear();
                int Month = feed.get(i).getMonth();
                int Day = feed.get(i).getDay();
                // set year, month and date to variables
                Date dateToCompare = new Date(Year, Month,Day);
                // put the into the comparison object
                int result = today.compareTo(dateToCompare);
                //future
                if (result == -1 ) {
                    System.out.println(feed.get(i));
                }
                // same day
                else if (result == 0) {
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
