import java.time.LocalDate;
import java.util.*;

public class Main {

    public static Date stringToDate (String date) {
        String strYear = date.substring(0,4);
        int intYear = Integer.parseInt(strYear);
        String strMonth = date.substring(5,7);
        int intMonth = Integer.parseInt(strMonth);
        String strDay = date.substring(8,10);
        int intDay = Integer.parseInt(strDay);
        Date newDate = new Date(intYear,intMonth-1,intDay);
        return newDate;
    }

    public static void main(String[] args) {

        // Variables
        ArrayList<Room> allRooms = new ArrayList<Room>();
        ArrayList<Customer> allCustomers = new ArrayList<Customer>();
        ArrayList<Reservation> allReservations = new ArrayList<Reservation>();
        Scanner scan = new Scanner(System.in);

        // Bungalows Test
        Bungalows bungalows1 = new Bungalows("The Shelly",110);
        Bungalows bungalows2 = new Bungalows("Dream Cove",160);
        Bungalows bungalows3 = new Bungalows("Pacific Pleasure",130);
        Bungalows bungalows4 = new Bungalows("Sunset Paradise",140);

        // Cottage Test
        Cottage cottage1 = new Cottage("Perlita de Oro",265);
        Cottage cottage2 = new Cottage("The Mermaid",250);
        Cottage cottage3 = new Cottage("Poseidon's Lair",350);

        // add all the rooms to the ArrayList
        allRooms.add(bungalows1);
        allRooms.add(bungalows2);
        allRooms.add(bungalows3);
        allRooms.add(bungalows4);
        allRooms.add(cottage1);
        allRooms.add(cottage2);
        allRooms.add(cottage3);

        // Customer Test
        Customer customer1 = new Customer("Jimmy Sparks","jimmy.sparks@three.com");
        Customer customer2 = new Customer("Gloria Sparks","Gloria.sparks@three.com");
        Customer customer3 = new Customer("Dona Sparks","Dona.sparks@three.com");

        // adding all the customers
        allCustomers.add(customer1);
        allCustomers.add(customer2);
        allCustomers.add(customer3);

        // Reservation
        Date startDate1 = new Date(2019,10-1,05);
        Date endDate1 = new Date(2019,10-1,10);

        Date startDate2 = new Date(2019,10-1,12);
        Date endDate2 = new Date(2019,10-1,15);

        Date startDate3 = new Date(2019,10-1,17);
        Date endDate3 = new Date(2019,10-1,21);
        Reservation reservation1 = new Reservation(bungalows1,customer1,startDate1,endDate1);
        Reservation reservation2 = new Reservation(bungalows1,customer1,startDate2,endDate2);
        Reservation reservation3 = new Reservation(bungalows1,customer1,startDate3,endDate3);
        System.out.println(reservation1.toString());

        // adding all the reservations
        allReservations.add(reservation1);
        allReservations.add(reservation2);
        allReservations.add(reservation3);


        System.out.println("Welcome to California Hotel");
        System.out.println("___________________________");
        System.out.println(" ");

        int stopper = 0;

        do {
        System.out.println("Main Menu");
        System.out.println("C) Create a new reservation");
        System.out.println("V) View Reservation");
        System.out.println("E) Edit an existing reservation");
        System.out.println("S) Shut Down");
        System.out.println(" ");
        System.out.println("Option: ");
        String menuOption = scan.nextLine();

            if (menuOption.equalsIgnoreCase("C")) {
                System.out.println("C was selected");
            } else if (menuOption.equalsIgnoreCase("V")) {
                // displays all the reservations
//                for (int i = 0; i < allReservations.size() ; i++) {
//                    System.out.println(allReservations.get(i));
//                }
                System.out.println(" ");
                System.out.println("Select a reservation ID: ");
                int vOption = Integer.parseInt(scan.nextLine().trim());
                // fix look up for the correction of index
                if (vOption+1 <= allReservations.size()) {
                    System.out.println(allReservations.get(vOption-1));
                } else {
                    System.out.println("Invalid option");
                }







                System.out.println("V was selected");
            } else if (menuOption.equalsIgnoreCase("E")) {
                System.out.println("E was selected");
            } else if (menuOption.equalsIgnoreCase("S")) {
                System.out.println("S was selected");
                stopper = 1 ;
            }

        } while (stopper==0);




        // display all the rooms
        for (int i = 0; i < allRooms.size(); i++) {
            System.out.println(allRooms.get(i));
        }

        /**
         * Create new reservation
         */

        System.out.println("What type of lodging do you want to reserve? ");
        System.out.println("B) Bungalow");
        System.out.println("C) Cottage");


        System.out.println("Option: ");
        String lodgingScan = scan.nextLine();

        if (lodgingScan.equalsIgnoreCase("B")){
            System.out.println("You are now reserving a bungalow");
            for (int i = 0; i < allRooms.size(); i++) {
                if (allRooms.get(i) instanceof Bungalows ) {
                    System.out.println(allRooms.get(i));
                }
            }
            System.out.println("Select a room by the ID above: ");
            int bungalowId = Integer.parseInt(scan.nextLine().trim());

            System.out.println("When do you want to check in? (YYY-MM-DD)");
            String bungalowCheckIn = scan.nextLine();
            Date bungalowCheckInDate = stringToDate(bungalowCheckIn);
            System.out.println("bungalowCheckInDate: "+bungalowCheckInDate);

            System.out.println("How many nights do you want to stay? ");
            int bungalowStayLength = Integer.parseInt(scan.nextLine().trim());


            // check if check in day is available

            /**
             * Logic to check room availability
             */
            // TODO: Consolidate Logic Here
            for (int i = 0; i < allReservations.size() ; i++) {
                if (allReservations.get(i).getId() == bungalowId) {

                    if (allReservations.get(i).getStartDate().equals(bungalowCheckInDate)){
                        System.out.println("Check in = Start Date"); // 2019-10-12
                        System.out.println(allReservations.get(i));
                    } else if (allReservations.get(i).getEndDate().equals(bungalowCheckInDate)) {
                        System.out.println("Check in = End Date"); // 2019-10-15
                        System.out.println(allReservations.get(i));
                    } else if (allReservations.get(i).getStartDate().before(bungalowCheckInDate) && allReservations.get(i).getEndDate().after(bungalowCheckInDate)){
                        System.out.println("Check in = Between Start End Day"); // 2019-10-14
                        System.out.println(allReservations.get(i));
                    } else {
                        System.out.println(allReservations.get(i));
                        System.out.println("Good to go");

                    }
                }

            }
            // create a new user

            System.out.println("Enter Customer Name: ");
            String name = scan.nextLine();
            System.out.println("Enter Customer Name: ");
            String email = scan.nextLine();
            Customer newCustomer = new Customer(name,email);



            int AcLoopStopper = 0;
            do {
                System.out.println("Would you like to upgrade and add AC for $20/night? (Y/N) ");
                String acUpgrade = scan.nextLine();
                if (acUpgrade.equalsIgnoreCase("Y")){
                    AcLoopStopper = 1;
                    // add AC
                } else if (acUpgrade.equalsIgnoreCase("N")) {
                    AcLoopStopper = 1;
                    // do not add ac but continue
                }
            } while (AcLoopStopper == 0);

//                        Reservation newReservation = new Reservation()


            // check if check + stay is available

        } else if (lodgingScan.equalsIgnoreCase("C")){
            System.out.println("You are now reserving a cottage");
            for (int i = 0; i < allRooms.size(); i++) {
                if (allRooms.get(i) instanceof Cottage ) {
                    System.out.println(allRooms.get(i));
                }
            }
        } else {
            System.out.println("Not a valid option");
        }



    }
}
