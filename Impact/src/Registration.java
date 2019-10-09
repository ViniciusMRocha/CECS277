public class Registration {
    private static int idGenerator = 0;
    private int id;
    private User username;
    private User eventName;

    public Registration(User username, User eventName) {
        idGenerator++;
        this.id = idGenerator;
        this.username = username;
        this.eventName = eventName;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    public User getEventName() {
        return eventName;
    }

    public void setEventName(User eventName) {
        this.eventName = eventName;
    }

    @Override
    public String toString() {
        return "Registration{" +
                ", username=" + username +
                ", eventName=" + eventName +
                '}';
    }
}
