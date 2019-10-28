import java.time.LocalDate;
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

    public static void main(String[] args) {

        /**
         * Set Up
         */


        // Variables
        ArrayList<Room> allRoomOptions = new ArrayList<Room>();
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
        allRoomOptions.add(bungalows1);
        allRoomOptions.add(bungalows2);
        allRoomOptions.add(bungalows3);
        allRoomOptions.add(bungalows4);
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
        Date startDate1 = new Date(2019,10-1,05);
        Date endDate1 = new Date(2019,10-1,10);

        Date startDate2 = new Date(2019,10-1,12);
        Date endDate2 = new Date(2019,10-1,15);

        Date startDate3 = new Date(2019,10-1,17);
        Date endDate3 = new Date(2019,10-1,21);
        Reservation reservation1 = new Reservation(bungalows1,customer1,startDate1,endDate1);
        Reservation reservation2 = new Reservation(bungalows2,customer2,startDate2,endDate2);
        Reservation reservation3 = new Reservation(bungalows3,customer3,startDate3,endDate3);
        System.out.println(reservation1.toString());

        // adding all the reservations
        allReservations.add(reservation1);
        allReservations.add(reservation2);
        allReservations.add(reservation3);







        System.out.println("Welcome to California Hotel");
        System.out.println("___________________________");


        int stopper = 0;

        do {
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
                // - - - - - - - - - - - - - - - - OPTION B - - - - - - - - - - - - - - - -
                if (lodgingScan.equalsIgnoreCase("B")){
                    System.out.println("Select a bungalow below\n");
                    // dispay all the options for Bungalows
                    for (int i = 0; i < allRoomOptions.size(); i++) {
                        if (allRoomOptions.get(i) instanceof Bungalows ) {
                            System.out.println(allRoomOptions.get(i));
                        }
                    }

                    // STEP: Pick a room bases on the ID
                    System.out.println("\nSelect a room by the ID above: ");
                    int bungalowId = Integer.parseInt(scan.nextLine().trim());

                    Room selectedRoom = null;
                    // TODO: Add a do while here
                        // create a room accordantly
                        if (bungalowId == 1) { // create a bungalow1
                            selectedRoom = bungalows1;

                        } else if (bungalowId == 2) { // create a bungalow2
                            selectedRoom = bungalows2;

                        } else if (bungalowId == 3) { // create a bungalow3
                            selectedRoom = bungalows3;

                        } else if (bungalowId == 4) { // create a bungalow4
                            selectedRoom = bungalows4;

                        } else {
                            System.out.println("Not a valid option");
                        }

                    // STEP: Enter the check in date

                    // Check In
                    System.out.println("\nWhen do you want to check in? (YYY-MM-DD)");
                    String inDate = scan.nextLine();
                    Date bungalowCheckInDate = stringToDate(inDate);

                    // Check Out
                    System.out.println("\nHow many nights do you want to stay? ");
                    int bungalowStayLength = Integer.parseInt(scan.nextLine().trim());

                    Calendar checkOutDay = Calendar.getInstance();
                    // Enter same day as check in

                    checkOutDay.set(bungalowCheckInDate.getYear(),bungalowCheckInDate.getMonth()+1,bungalowCheckInDate.getDay()); // 0 is january
                    Date checkOut =  checkOutDay.getTime();

                    SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, YYYY");

                    String checkInDate = sdf.format(bungalowCheckInDate);
                    String checkOutDate = sdf.format(checkOut);

                    System.out.println("checkOutDate Before adding: " + checkOutDate);
                    checkOutDay.add(Calendar.DATE,120);
                    System.out.println("checkOutDate After adding: "+checkOutDate);


                    // STEP: Enter the number of nights
                    // TODO: Not working for when the number of nights goes beyond the month selected
//                    Date bungalowCheckOutDate = stringToDate(bungalowCheckIn);
//                    int checkOutDate = bungalowCheckOutDate.getDay();
//                    checkOutDate = bungalowStayLength + checkOutDate;
//                    bungalowCheckOutDate.setDate(checkOutDate);

                    /**
                     * Logic to check room availability
                     */
                    // TODO: Consolidate Logic Here
//                    for (int i = 0; i < allReservations.size() ; i++) {
//                        if (allReservations.get(i).getId() == bungalowId) {
//
//                            if (allReservations.get(i).getStartDate().equals(bungalowCheckInDate)){
//                                System.out.println("Check in = Start Date"); // 2019-10-12
//                                System.out.println(allReservations.get(i));
//                            } else if (allReservations.get(i).getEndDate().equals(bungalowCheckInDate)) {
//                                System.out.println("Check in = End Date"); // 2019-10-15
//                                System.out.println(allReservations.get(i));
//                            } else if (allReservations.get(i).getStartDate().before(bungalowCheckInDate) && allReservations.get(i).getEndDate().after(bungalowCheckInDate)){
//                                System.out.println("Check in = Between Start End Day"); // 2019-10-14
//                                System.out.println(allReservations.get(i));
//                            } else {
//                                System.out.println(allReservations.get(i));
//                                System.out.println("Good to go");
//
//                            }
//                        }
//
//                    }

                    // TODO: FIX The checkout date here
                    Reservation r = new Reservation(selectedRoom,bungalowCheckInDate,bungalowCheckInDate);
//                    Reservation r = new Reservation(selectedRoom,bungalowCheckInDate,bungalowCheckOutDate);

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

                    r.addPatron(c);

                    int AcLoopStopper = 0;
                    do {
                        System.out.println("\nWould you like to upgrade and add AC for $20/night? (Y/N) ");
                        String acUpgrade = scan.nextLine();
                        if (acUpgrade.equalsIgnoreCase("Y")){
                            AcLoopStopper = 1;
                            // adding ac
                            r.addToTotal(20,bungalowStayLength);
                        } else if (acUpgrade.equalsIgnoreCase("N")) {
                            AcLoopStopper = 1;
                            // do not add ac but continue
                        }
                    } while (AcLoopStopper == 0);

                    //calculating total
                    r.setTotal(selectedRoom.getRate(),bungalowStayLength);

                    // Making reservation
                    allReservations.add(r);

                    System.out.println(" -----------------------");
                    System.out.println("| Reservation Completed |");
                    System.out.println(" -----------------------");
                    System.out.println("\nYour confirmation number is: "+r.getId());
                    // TODO: get a way to caculate difernce between dates
                    System.out.println("\nYour total is: $"+r.getTotal()+"\n");
                }

                // - - - - - - - - - - - - - - - - OPTION C - - - - - - - - - - - - - - - -
                else if (lodgingScan.equalsIgnoreCase("C")){
                    System.out.println("You are now reserving a cottage");
                    for (int i = 0; i < allRoomOptions.size(); i++) {
                        if (allRoomOptions.get(i) instanceof Cottage ) {
                            System.out.println(allRoomOptions.get(i));
                        }
                    }
                } else {
                    System.out.println("Not a valid option");
                }
            }

            /**
             * - - - - - - - - - - - - - - - - - - - - - - - - - - - OPTION V - - - - - - - - - - - - - - - - - - - - - - - - - - -
             * DONE
             */
            else if (menuOption.equalsIgnoreCase("V")) {
                // displays all the reservations
                for (int i = 0; i < allReservations.size() ; i++) {
                    System.out.println(allReservations.get(i));
                }
                System.out.println("\nSelect a reservation ID: ");
                int vOption = Integer.parseInt(scan.nextLine().trim());
                // fix look up for the correction of index
                if (vOption <= allReservations.size()) {
                    System.out.println(allReservations.get(vOption-1));
                } else {
                    System.out.println("\nInvalid option\n");

                }
            }


            /**
             * - - - - - - - - - - - - - - - - - - - - - - - - - - - OPTION E - - - - - - - - - - - - - - - - - - - - - - - - - - -
             */
            else if (menuOption.equalsIgnoreCase("E")) {
                System.out.println("E was selected");
            }


            /**
             * - - - - - - - - - - - - - - - - - - - - - - - - - - - OPTION S - - - - - - - - - - - - - - - - - - - - - - - - - - -
             */
            else if (menuOption.equalsIgnoreCase("S")) {
                System.out.println("S was selected");
                stopper = 1 ;
            }

            /**
             * - - - - - - - - - - - - - - - - - - - - - - - - - - - Other Options - - - - - - - - - - - - - - - - - - - - - - - - - - -
             */
            else {
                System.out.println("\nNOT a valid option\n");
            }

        } while (stopper==0);

    }
}
