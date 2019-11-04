//import sun.jvm.hotspot.HelloWorld;
//
//import java.util.Date;
//import java.util.Calendar;
//import java.text.SimpleDateFormat;
//
//public class DatesTest {
//
//    public long daysBetween(Date one, Date two) {
//        long diff = (one.getTime()-two.getTime())/86400000; // 86400000 in the number of millisecond
//        return Math.abs(diff);
//    }
//
//    public static void main(String[] args) {
//
//        Date checkIn = new Date();
//
//        Calendar checkOutDay = Calendar.getInstance();
//        // Enter same day as check in
//        checkOutDay.set(2019,11,24); // 0 is january
//        Date checkOut =  checkOutDay.getTime();
//
//        DatesTest myObject = new DatesTest();
//
//        long days = myObject.daysBetween(checkIn,checkOut);
//
//        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, YYYY");
//
//        String checkInDate = sdf.format(checkIn);
//        String checkOutDate = sdf.format(checkOut);
//
//        System.out.println(days + "Days from checkIn's date of "+checkInDate +" until "+checkOutDate);
//
//    }
//}
