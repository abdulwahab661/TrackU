import java.io.Serializable;

public class Person extends Resume implements Serializable {
    private String username;
    private String password;

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }

    public String getPassword() { return password; }

    public Resume getResume() {
        return this; // since Person extends Resume, this is valid
    }
}
