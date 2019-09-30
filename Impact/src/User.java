public class User {
    private static int idGenerator = 0;
    private int id;
    private String name;
    private String email;
    private String username;
    private String password;
    private String bio;

    public User(String name, String email, String username, String password, String bio) {
        idGenerator++;
        this.id = idGenerator;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.bio = bio;
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



    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", bio='" + bio + '\''
                ;
    }
}