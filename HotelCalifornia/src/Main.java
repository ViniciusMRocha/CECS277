import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.text.SimpleDateFormat;


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

    public static boolean compareCheckIn(ArrayList<Reservation> allReservations,LocalDate checkIn, LocalDate checkOut){

        Boolean dateValidation = true;
        for (int i = 0; i < allReservations.size(); i++) {

            if (checkIn.isBefore(allReservations.get(i).getStartDate())     &&      (checkOut.isBefore(allReservations.get(i).getStartDate()) || checkOut.isEqual(allReservations.get(i).getStartDate()))
            ) {
                // System.out.println("Clear");
            } else if ((checkIn.isAfter(allReservations.get(i).getEndDate()) || checkIn.isEqual(allReservations.get(i).getEndDate()))     &&      checkOut.isAfter(allReservations.get(i).getEndDate())) {
                // System.out.println("Clear");
            } else {
                // System.out.println(" NOT CLEAR");
                dateValidation = false;
            }
        }
        return dateValidation;
    }

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

        // Customer Test
        Customer customer1 = new Customer("Jimmy Sparks","jimmy.sparks@three.com");
        Customer customer2 = new Customer("Gloria Sparks","Gloria.sparks@three.com");
        Customer customer3 = new Customer("Dona Sparks","Dona.sparks@three.com");

        // adding all the customers
        allCustomers.add(customer1);
        allCustomers.add(customer2);
        allCustomers.add(customer3);

        // Reservation


        LocalDate startDate1 = covertDate("2019-10-05");
        LocalDate startDate2 = covertDate("2019-10-12");
        LocalDate startDate3 = covertDate("2019-10-17");
        LocalDate endDate1 = covertDate("2019-10-09");
        LocalDate endDate2 = covertDate("2019-10-15");
        LocalDate endDate3 = covertDate("2019-10-21");

        Reservation reservation1 = new Reservation(bungalows1,customer1,startDate1,endDate1);
        Reservation reservation2 = new Reservation(bungalows2,customer2,startDate2,endDate2);
        Reservation reservation3 = new Reservation(bungalows3,customer3,startDate3,endDate3);
        Reservation reservation4 = new Reservation(cottage1,customer1,startDate1,endDate1);
        Reservation reservation5 = new Reservation(cottage3,customer2,startDate2,endDate2);
        Reservation reservation6 = new Reservation(cottage3,customer3,startDate3,endDate3);


        // adding all the reservations
        allReservations.add(reservation1);
        allReservations.add(reservation2);
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
                System.out.println("C was selected\n");
                System.out.println("What type of lodging do you want to reserve? \n");
                System.out.println("B) Bungalow");
                System.out.println("C) Cottage");
                System.out.println("\nOption: ");
                String lodgingScan = scan.nextLine();

                /**
                 * Create new reservation
                 */

                boolean cMenuStopper = true;
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

                    // STEP: Enter the check in date

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


                    if ( compareCheckIn(allReservations,checkIn,checkOut) ) {

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

                    System.out.println(" -----------------------");
                    System.out.println("| Reservation Completed |");
                    System.out.println(" -----------------------");
                    System.out.println("\nYour confirmation number is: "+r.getId());
                    System.out.println("\nYour deposit total is: $"+r.getDeposit());
                    System.out.println("\nYour total is: $"+r.getTotal()+"\n");
                    }
                    else {
                        System.out.println("\nThe room is not available for the dates that you have picked");
                        System.out.println("\n would you like to be added to the waiting list for this room? (Y/N)");
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
                                selectedRoom.addToWaitlist(r);

                                System.out.println("Print waitlist");
                                selectedRoom.getWaitlist();
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

                    if (eSubMenu.equalsIgnoreCase( "N")){
                        System.out.println("How many nights do you want? ");
                        int updateNights = Integer.parseInt(scan.nextLine().trim());

                        LocalDate newCheckIn = editReservation.getStartDate();
                        LocalDate newCheckOut = newCheckIn.plusDays(updateNights);

                        System.out.println("\nCheck In: " + newCheckIn);
                        System.out.println("Check Out: " + newCheckOut);

                        if (compareCheckIn(allReservations,newCheckIn,newCheckOut)) {
                            System.out.println("Edits were recorded");
                            editReservation.setEndDate(newCheckOut);
                            editReservation.setStayLen(updateNights);
                        } else {
                            System.out.println("Edits are not able to be recorded. The new dates are not available");
                        }
                    }
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
                    else if (eSubMenu.equalsIgnoreCase("C")) {
                        editReservation.setAvailable(false);
                        System.out.println("\nReservation was canceled\n");
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
