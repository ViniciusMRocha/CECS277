import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Main {

    public static void displayUpdate (Room r) {
        r.update();
    }

    public static LocalDate covertDate (String d) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(d,formatter);
        return date;
    }


    public static void main(String[] args) {

        /**
         * Set Up
         */

        // Variables
        ArrayList<Room> allRoomOptions = new ArrayList<Room>();
        ArrayList<Customer> allCustomers = new ArrayList<Customer>();
        ArrayList<Reservation> allReservations = new ArrayList<Reservation>();
        Scanner scan = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


        // Bungalows Test
        Bungalows bungalows1 = new Bungalows("Morning Glory",140);
        Bungalows bungalows2 = new Bungalows("The Shelly",110);
        Bungalows bungalows3 = new Bungalows("Dream Cove",160);
        Bungalows bungalows4 = new Bungalows("Pacific Pleasure",130);
        Bungalows bungalows5 = new Bungalows("Sunset Paradise",140);

        // Cottage Test
        Cottage cottage1 = new Cottage("Perlita de Oro",265);
        Cottage cottage2 = new Cottage("The Mermaid",250);
        Cottage cottage3 = new Cottage("Poseidon's Lair",350);

        // add all the rooms to the ArrayList
        allRoomOptions.add(bungalows1);
        allRoomOptions.add(bungalows2);
        allRoomOptions.add(bungalows3);
        allRoomOptions.add(bungalows4);
        allRoomOptions.add(bungalows5);
        allRoomOptions.add(cottage1);
        allRoomOptions.add(cottage2);
        allRoomOptions.add(cottage3);

        // Customer
        Customer customer1 = new Customer("Jane Doe","1234 Beach Blvd. Long Beach, CA", "(562) 555-1234","jdoe@gmail.com","1234 5678 9012","Jane M. Done","08/20","851");
        Customer customer2 = new Customer("Pam Zo","9801 Aspen Ave. Norwalk, CA", "(562) 555-1234","pamzo@gmail.com","2468 1012 1416","Pamela Zo","04/22","123");
        Customer customer3 = new Customer("Tim Johnson","4657 Colorado St. Santa Ana, CA", "(562) 555-1234","tj89@gmail.com","1357 9111 3151","Ana Johnson","12/19","545");
        Customer customer4 = new Customer("Antonio Vargas","7654 Colonia Ave. Mission Hills, CA", "(714) 555-1965","varan@gmail.com","2021 2223 2425","Pamela Zo","04/22","123");


        // adding all the customers
        allCustomers.add(customer1);
        allCustomers.add(customer2);


        LocalDate startDate1 = covertDate("2019-11-08");
        LocalDate endDate1 = covertDate("2019-11-13");

        LocalDate startDate2 = covertDate("2019-11-13");
        LocalDate endDate2 = covertDate("2019-11-16");

        LocalDate startDate3 = covertDate("2019-11-10");
        LocalDate endDate3 = covertDate("2019-11-13");

        // Reservation
        Reservation reservation1 = new Reservation(bungalows1,customer1,startDate1,endDate1,0,5);
        Reservation reservation2 = new Reservation(bungalows1,customer2,startDate2,endDate2,0,3);

        // adding all the reservations
        allReservations.add(reservation1);
        reservation1.getRoom().setCurrentReservation(reservation1);
        allReservations.add(reservation2);
        reservation2.getRoom().setCurrentReservation(reservation2);

        Reservation reservation3 = new Reservation(bungalows1,customer3,startDate3,endDate3,0,3);
        Reservation reservation4 = new Reservation(cottage1,customer3,startDate3,endDate3,2,3);
        Reservation reservation5 = new Reservation(bungalows1,customer4,startDate3,endDate3,0,3);
        Reservation reservation6 = new Reservation(bungalows5,customer3,startDate3,endDate3,1,3);

        bungalows1.addReserve(reservation3);
        cottage1.addReserve(reservation4);
        bungalows1.addReserve(reservation5);
        bungalows5.addReserve(reservation6);

        allReservations.add(reservation3);
        allReservations.add(reservation4);
        allReservations.add(reservation5);
        allReservations.add(reservation6);

        int stopper = 0;

        do {
        System.out.println("Welcome to California Hotel");
        System.out.println("___________________________");
        System.out.println("\nMain Menu\n");
        System.out.println("C) Create a new reservation");
        System.out.println("V) View Reservation");
        System.out.println("E) Edit an existing reservation");
        System.out.println("S) Shut Down");
        System.out.println("\nOption: ");
        // record the option
        String menuOption = scan.nextLine();

            /**
             * - - - - - - - - - - - - - - - - - - - - - - - - - - - OPTION C - - - - - - - - - - - - - - - - - - - - - - - - - - -
             */
            if (menuOption.equalsIgnoreCase("C")) {
                System.out.println("\nWhat type of lodging do you want to reserve? \n");
                System.out.println("B) Bungalow");
                System.out.println("C) Cottage");
                System.out.println("\nOption: ");
                String lodgingScan = scan.nextLine();

                /**
                 * Create new reservation
                 */

                Room selectedRoom = null;

                // - - - - - - - - - - - - - - - - OPTION B - - - - - - - - - - - - - - - -
                if (lodgingScan.equalsIgnoreCase("B")){
                    System.out.println("Select a bungalow below\n");
                    // dispay all the options for Bungalows
                    for (int i = 0; i < allRoomOptions.size(); i++) {
                        if (allRoomOptions.get(i) instanceof Bungalows ) {
                            System.out.println(allRoomOptions.get(i));
                        }
                    }

                    boolean bungalowStopper;
                    do {
                    // STEP: Pick a room bases on the ID
                    System.out.println("\nSelect a room by the ID above: ");
                    int bungalowId = Integer.parseInt(scan.nextLine().trim());

                        // create a room accordantly
                        if (bungalowId == 1) { // create a bungalow1
                            selectedRoom = bungalows1;
                            bungalowStopper = true;
                        } else if (bungalowId == 2) { // create a bungalow2
                            selectedRoom = bungalows2;
                            bungalowStopper = true;
                        } else if (bungalowId == 3) { // create a bungalow3
                            selectedRoom = bungalows3;
                            bungalowStopper = true;
                        } else if (bungalowId == 4) { // create a bungalow4
                            selectedRoom = bungalows4;
                            bungalowStopper = true;
                        } else if (bungalowId == 5) { // create a bungalow3
                            selectedRoom = bungalows5;
                            bungalowStopper = true;
                        } else {
                            System.out.println("Not a valid option");
                            bungalowStopper = false;
                        }
                    } while (!bungalowStopper);
                }

                // - - - - - - - - - - - - - - - - OPTION C - - - - - - - - - - - - - - - -
                else if (lodgingScan.equalsIgnoreCase("C")) {
                    System.out.println("You are now reserving a cottage");
                    for (int i = 0; i < allRoomOptions.size(); i++) {
                        if (allRoomOptions.get(i) instanceof Cottage) {
                            System.out.println(allRoomOptions.get(i));
                        }
                    }

                    boolean cottageStopper;
                    do {
                    System.out.println("\nSelect a room by the ID above: ");
                    int cottageId = Integer.parseInt(scan.nextLine().trim());

                    // create a room accordantly
                    if (cottageId == 6) { // create a cottage1
                        selectedRoom = cottage1;
                        cottageStopper = true;

                    } else if (cottageId == 7) { // create a cottage2
                        selectedRoom = cottage1;
                        cottageStopper = true;

                    } else if (cottageId == 8) { // create a cottage3
                        selectedRoom = cottage1;
                        cottageStopper = true;

                    } else {
                        System.out.println("Not a valid option");
                        cottageStopper = false;
                    }
                    } while (!cottageStopper);
                }


                // - - - - - - - - - - - - - - - - CHECK IN DATE - - - - - - - - - - - - - - - -

                    // Check In
                    System.out.println("\nWhen do you want to check in? (YYYY-MM-DD)");
                    String inDate = scan.nextLine();
                    LocalDate checkIn = LocalDate.parse(inDate);

                    // Check Out
                    System.out.println("\nHow many nights do you want to stay? ");
                    int stayLength = Integer.parseInt(scan.nextLine().trim());

                    LocalDate checkOut = checkIn.plusDays(stayLength);

                    System.out.println("\nCheck In: " + checkIn);
                    System.out.println("Check Out: " + checkOut);

                    ArrayList <Reservation> availabilityCheck = new ArrayList<>();
                    for (int i = 0; i < allReservations.size(); i++) {
                        if (allReservations.get(i).getRoom().getId() == selectedRoom.getId()) {
                            availabilityCheck.add(allReservations.get(i));
                        }
                    }

                    if ( selectedRoom.compareCheckIn(availabilityCheck,checkIn,checkOut) ) {

                // Adding a customer
                    System.out.println("\nEnter Customer Information");
                    System.out.println("Name: ");
                    String name = scan.nextLine();
                    System.out.println("Address: ");
                    String address = scan.nextLine();
                    System.out.println("Phone: ");
                    String phone = scan.nextLine();
                    System.out.println("Email: ");
                    String email = scan.nextLine();
                    System.out.println("Card Number: ");
                    String ccNumber = scan.nextLine();
                    System.out.println("Name on the Card: ");
                    String ccName = scan.nextLine();
                    System.out.println("Card Exp. Date (YYYY-MM-DD): ");
                    String ccDate = scan.nextLine();
                    System.out.println("Security Code: ");
                    String ccSecurity = scan.nextLine();

                    Customer c = new Customer(name,address,phone,email,ccNumber,ccName,ccDate,ccSecurity);
                    
                    
                int loopStopper = 0;
                int upgradeLen = 0;


                    do {
                        // polymorphic method
                        System.out.println("This room has the following update");
                        displayUpdate(selectedRoom);
                        System.out.println("Do you want to add it? (Y/N) ");
                        String upgradeDecision = scan.nextLine();
                        if (upgradeDecision.equalsIgnoreCase("Y")){
                            loopStopper = 1;
                            
                            System.out.println("How long do you want it for? ");
                            upgradeLen = Integer.parseInt(scan.nextLine().trim());

                        } else if (upgradeDecision.equalsIgnoreCase("N")) {
                            loopStopper = 1;
                            // do not add ac but continue
                        }
                    } while (loopStopper == 0);


                    // Making reservation
                    Reservation r = new Reservation( selectedRoom, c, checkIn,checkOut, upgradeLen, stayLength);
                    allReservations.add(r);
                    r.getRoom().setCurrentReservation(r);

                    System.out.println(" -----------------------");
                    System.out.println("| Reservation Completed |");
                    System.out.println(" -----------------------");
                    System.out.println("\nYour confirmation number is: "+r.getId());
                    System.out.println("\nYour deposit total is: $"+r.getDeposit());
                    System.out.println("\nYour total is: $"+r.getTotal()+"\n");
                    }
                    else {
                        System.out.println("\nThe room is not available for the dates that you have picked");
                        System.out.println("\nWould you like to be added to the waiting list for this room? (Y/N)");
                        String wait = scan.nextLine();

                        int waitStoper = 0;
                        do {
                            if (wait.equalsIgnoreCase("Y")) {
                                waitStoper = 1;
                                System.out.println("\nEnter Customer Information");
                                System.out.println("Name: ");
                                String name = scan.nextLine();
                                System.out.println("Address: ");
                                String address = scan.nextLine();
                                System.out.println("Phone: ");
                                String phone = scan.nextLine();
                                System.out.println("Email: ");
                                String email = scan.nextLine();
                                System.out.println("Card Number: ");
                                String ccNumber = scan.nextLine();
                                System.out.println("Name on the Card: ");
                                String ccName = scan.nextLine();
                                System.out.println("Card Exp. Date (YYYY-MM-DD): ");
                                String ccDate = scan.nextLine();
                                System.out.println("Security Code: ");
                                String ccSecurity = scan.nextLine();

                                Customer c = new Customer(name,address,phone,email,ccNumber,ccName,ccDate,ccSecurity);


                                int loopStopper = 0;
                                int upgradeLen = 0;


                                do {
                                    // polymorphic method
                                    System.out.println("This room has the following update");
                                    displayUpdate(selectedRoom);
                                    System.out.println("Do you want to add it? (Y/N) ");
                                    String upgradeDecision = scan.nextLine();
                                    if (upgradeDecision.equalsIgnoreCase("Y")){
                                        loopStopper = 1;

                                        System.out.println("How long do you want it for? ");
                                        upgradeLen = Integer.parseInt(scan.nextLine().trim());

                                    } else if (upgradeDecision.equalsIgnoreCase("N")) {
                                        loopStopper = 1;
                                        // do not add ac but continue
                                    }
                                } while (loopStopper == 0);



                                // Making reservation
                                Reservation r = new Reservation( selectedRoom, c, checkIn ,checkOut, upgradeLen, stayLength);
                                r.updateReservation(r);
                                // Observer pattern
                                selectedRoom.addReserve(r);
                                System.out.println(" ");
                                selectedRoom.printWaitlist();
                                System.out.println("\nYour reservation has been added to the waiting list");
                                allReservations.add(r);
                                System.out.println("We will let you know if the room was made available\n");


                            } else if (wait.equalsIgnoreCase("N")){
                                waitStoper = 1;
                                System.out.println("\nYou will not be added to the waitlist at this moment");
                            }
                            else {
                                System.out.println("\nNot a valid option");
                            }
                        } while (waitStoper == 0);
                    }
                }

            /**
             * - - - - - - - - - - - - - - - - - - - - - - - - - - - OPTION V - - - - - - - - - - - - - - - - - - - - - - - - - - -
             * DONE
             */
            else if (menuOption.equalsIgnoreCase("V")) {

                boolean stop = false;
                do {
                    System.out.println("\nSelect a reservation to be viewed ID: ");

                    try {
                        int vOption = Integer.parseInt(scan.nextLine().trim());

                    for (int i = 0; i < allReservations.size(); i++) {
                        if (vOption == allReservations.get(i).getId()){
                            System.out.println(allReservations.get(i));
                            stop = true;
                        }
                    }
                    if (!stop) {
                        System.out.println("\nReservation ID not found\n");
                    }
                    } catch (NumberFormatException e) {
                        String errorMsg = "Not a proper ID, try again";
                        System.out.println(errorMsg);
                    }
                } while (!stop);
            }

            /**
             * - - - - - - - - - - - - - - - - - - - - - - - - - - - OPTION E - - - - - - - - - - - - - - - - - - - - - - - - - - -
             * DONE
             */
            else if (menuOption.equalsIgnoreCase("E")) {

                Reservation editReservation = null;

                boolean stop = false;
                do {
                    try {
                    System.out.println("\nSelect a reservation to be editied ID: ");
                    int eOption = Integer.parseInt(scan.nextLine().trim());

                    for (int i = 0; i < allReservations.size() ; i++) {
                        if (eOption == allReservations.get(i).getId()){
                            editReservation = allReservations.get(i);
                            System.out.println(editReservation);
                            stop = true;
                        }
                    }
                    if (!stop){
                        System.out.println("\nReservation ID not found\n");
                    }
                    } catch (NumberFormatException e) {
                        String errorMsg = "Not a proper ID, try again";
                        System.out.println(errorMsg);
                    }
                } while (!stop);

                System.out.println("\n N) Number of night");
                System.out.println(" C) Cancel Reservation");
                System.out.println(" U) Update Amenities");
                System.out.println(" E) Exit to Main Menu");

                String eSubMenu = scan.nextLine();


                // - - - - - - - - - - - - - - - - OPTION N - - - - - - - - - - - - - - - -
                if (eSubMenu.equalsIgnoreCase( "N")){
                        System.out.println("How many nights do you want? ");
                        int updateNights = Integer.parseInt(scan.nextLine().trim());

                        LocalDate newCheckIn = editReservation.getStartDate();
                        LocalDate newCheckOut = newCheckIn.plusDays(updateNights);

                        System.out.println("\nCheck In: " + newCheckIn);
                        System.out.println("Check Out: " + newCheckOut);

                        if (editReservation.getRoom().compareCheckIn(editReservation.getRoom().getWaitlist(),newCheckIn,newCheckOut)) {
                            System.out.println("Edits were recorded");
                            editReservation.setEndDate(newCheckOut);
                            editReservation.setStayLen(updateNights);
                        } else {
                            System.out.println("Edits are not able to be recorded. The new dates are not available");
                        }
                    }
                    // - - - - - - - - - - - - - - - - OPTION U - - - - - - - - - - - - - - - -
                    else if (eSubMenu.equalsIgnoreCase("U")) {
                        if (editReservation.getRoom() instanceof Bungalows) {
                            System.out.println("How many nights do you want to add AC? ");
                        } else if (editReservation.getRoom() instanceof Cottage) {
                            System.out.println("How many nights do you want to add cable TV? ");
                        }

                        int updateAmenities = Integer.parseInt(scan.nextLine().trim());

                        if (updateAmenities <= editReservation.getStayLen()) {
                            editReservation.setUpgradeLen(updateAmenities);
                            System.out.println("Upgrade recorded\n");
                        } else {
                            System.out.println("You cannot days add more then your stay");
                        }
                    }
                    // - - - - - - - - - - - - - - - - OPTION C - - - - - - - - - - - - - - - -
                    else if (eSubMenu.equalsIgnoreCase("C")) {

                        System.out.println("\nReservation was canceled\n");


                        allReservations.remove(editReservation);

                        // Observer Patter
                        editReservation.getRoom().notification(editReservation,allReservations);
                        editReservation.updateReservation(editReservation);

                    }
                    else if (eSubMenu.equalsIgnoreCase("E")) {
                        System.out.println("Exiting to main menu");

                    }
                    else {
                        System.out.println("\nInvalid option\n");

                    }
            }

            /**
             * - - - - - - - - - - - - - - - - - - - - - - - - - - - OPTION S - - - - - - - - - - - - - - - - - - - - - - - - - - -
             * DONE
             */
            else if (menuOption.equalsIgnoreCase("S")) {
                System.out.println("Shutting Down Program");
                stopper = 1 ;
            }

            /**
             * - - - - - - - - - - - - - - - - - - - - - - - - - - Other Options - - - - - - - - - - - - - - - - - - - - - - - - - -
             * DONE
             */
            else {
                System.out.println("\nNOT a valid option\n");
            }

        } while (stopper==0);
    }
}
