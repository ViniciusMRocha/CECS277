public class Post {
    private static int idGenerator = 0;
    private int id;
    private String message;
    private String date;

    public Post(String message) {
        idGenerator++;
        this.id = idGenerator;
        this.message = message;
    }

    public Post(String message,String date) {
        idGenerator++;
        this.id = idGenerator;
        this.message = message;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public int getYear () {
        String strYear = date.substring(0,4);
        int intYear = Integer.parseInt(strYear);
        return intYear;
    }
    public int getMonth () {
        String strMonth = date.substring(5,7);
        int intMonth = Integer.parseInt(strMonth);
        return intMonth;
    }
    public int getDay () {
        String strDay = date.substring(8,10);
        int intDay = Integer.parseInt(strDay);
        return intDay;
    }

    @Override
    public String toString() {
        return "Post ID "+ id +" { " + message +" }";
    }
}





