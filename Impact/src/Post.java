public class Post {
    private String user;
    private String message;
    private String file;

    public Post(String user,String message, String file) {
        this.user = user;
        this.message = message;
        this.file = file;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return  "user='" + user + '\'' +
                ", message='" + message + '\'' +
                ", file='" + file + '\''
                ;
    }
}
