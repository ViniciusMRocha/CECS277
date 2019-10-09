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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getBio() {
        return bio;
    }

    public String getUserType() {return userType;}

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
            ", userType='" + userType + '\'' +
            " "
        );
    }

    }