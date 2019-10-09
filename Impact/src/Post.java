public class Post {
    private static int idGenerator = 0;
    private int id;
    private String message;

    public Post(String message) {
        idGenerator++;
        this.id = idGenerator;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Post ID "+ id +" { " + message +" }";
    }
}





