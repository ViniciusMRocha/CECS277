public class Post {
    private static int idGenerator = 0;
    private int id;
    private String message;
    private String date;

    /**
     * Creates a post that has an ID number and a message
     * @param message String
     */
    public Post(String message) {
        idGenerator++;
        this.id = idGenerator;
        this.message = message;
    }

    /**
     * Creates a post that has an ID number, a message and a date for comparison
     * @param message String
     * @param date String
     */
    public Post(String message,String date) {
        idGenerator++;
        this.id = idGenerator;
        this.message = message;
        this.date = date;
    }

    /**
     * Returns the post's date
     * @return String
     */
    public String getDate() {
        return date;
    }

    /**
     * Returns the post's year or in case of an event the day that the event will take or took place
     * @return Int
     */
    public int getYear () {
        String strYear = date.substring(0,4);
        int intYear = Integer.parseInt(strYear);
        return intYear;
    }

    /**
     * Returns the post's month or in case of an event the day that the event will take or took place
     * @return Int
     */
    public int getMonth () {
        String strMonth = date.substring(5,7);
        int intMonth = Integer.parseInt(strMonth);
        return intMonth;
    }

    /**
     * Returns the post's day or in case of an event the day that the event will take or took place
     * @return Int
     */
    public int getDay () {
        String strDay = date.substring(8,10);
        int intDay = Integer.parseInt(strDay);
        return intDay;
    }

    /**
     * prints the post id and message
     * @return String
     */
    @Override
    public String toString() {
        return "Post ID "+ id +" { " + message +" }";
    }
}





