import java.time.LocalDate;
import java.util.Date;

public class DateNotes {
    public static void main(String[] args) {
        LocalDate t = LocalDate.now();

        Date today = new Date(t.getYear(),t.getMonthValue(),t.getDayOfMonth());

        Date tomorrow = new Date(2019, 10,8);

        System.out.println(today.compareTo(tomorrow));
    }



}
