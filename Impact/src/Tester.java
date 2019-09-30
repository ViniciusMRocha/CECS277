import java.util.*;

public class Tester {
    public static void main(String[] args) {

        // Users
        User andy = new User("Ayrie","Ayrie.Rocha@gmail.com", "Ayrie.Rocha", "Welc@me!", "Ayrie's Bio");
        User betty = new User("Betty","Betty.Nguyen@gmail.com", "Betty.Nguyen", "Welc@me!", "Betty Nguyen");
        User gloria = new User("Gloria","Gloria.Sparks@gmail.com", "Gloria.Sparks", "Welc@me!", "Gloria no one said enough is enough");

        // Individuals
        Individual jimmy = new Individual("Jimmy","Jimmy.Sparks@gmail.com", "Jimmy.Sparks", "Welc@me!", "Jimmy Sparks belived in the American way", "2019-01-01", "123-321-1234");

        // Organizations
        Organization impact = new Organization("Impact","Impact.corp@gmail.com","impact.corp","impact_corp","This company will take us diamond","123 Main","(778)908-7831","192-21-1244","931-129-1284");

        // VolunteerPage
        VolunteerPage philantropy = new VolunteerPage("DSP","dsp@gmail.com","dsp-pl","lambda213","CSULB chapter","1988-05-13","12:00","1250 Belflower", "(556)873-8823");

        System.out.println();
        System.out.println("----------------------------------- Users -----------------------------------");
        System.out.println();
        System.out.println(andy.toString());
        System.out.println(betty.toString());
        System.out.println(gloria.toString());

        System.out.println();
        System.out.println("----------------------------------- Individual -----------------------------------");
        System.out.println();
        System.out.println(jimmy.toString());

        System.out.println();
        System.out.println("----------------------------------- Organization -----------------------------------");
        System.out.println();
        System.out.println(impact.toString());

        System.out.println();
        System.out.println("----------------------------------- VolunteerPage -----------------------------------");
        System.out.println();
        System.out.println(philantropy.toString());


    }
}
