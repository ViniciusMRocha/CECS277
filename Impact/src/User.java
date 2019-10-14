import java.util.Scanner;

public abstract class User {
    private static int idGenerator = 0;
    private int id;
    private String name;
    private String email;
    private String username;
    private String password;
    private String bio;
    private String userType;

    /**
     * This constructor creates a object of the superclass user with has the attributes below. A user does not necessarily act on the application,
     * maily the child classes do
     * @param name - the full name of the user
     * @param email - users email
     * @param username - user's username (used to identify the user in the front end)
     * @param password - User's password
     * @param bio - Users' bio is a quick description about the user
     * @param userType - what king of user a certain user is. They can be either a Individual, an Organization or a Volunteer Event
     */
    public User(String name, String email, String username, String password, String bio, String userType) {
        idGenerator++;
        this.id = idGenerator;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.bio = bio;
        this.userType = userType;

    }

    /**
     * Returns the user unique identifies for each user
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * returns user's full name as a string
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * returns user's email as a string
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * return a user's username as a string
     * @return String
     */
    public String getUsername() {
        return username;
    }

    /**
     * return a user's password as a string
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     * return a user bio as a string
     * @return String
     */
    public String getBio() {
        return bio;
    }

    /**
     * returns a user's type (Individual, Organization or Volunteer Page)
     * @return String
     */
    public String getUserType() {return userType;}

    /**
     * prints the users attributes
     * @return String
     */
    @Override
    public String toString() {
        return  "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", bio='" + bio + '\'' +
                ", userType='" + userType + '\''
                ;
    }

    /**
     * prints the user's information
     */
    public void display() {
        int id = getId();
        String name = getName();
        String email = getEmail();
        String username = getUsername();
        String password = getPassword();
        String bio = getBio();
        String userType = getUserType();
        System.out.println(
            "id=" + id +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", bio='" + bio + '\'' +
            ", userType='" + userType + '\''+
            " "
        );
    }

    }