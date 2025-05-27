import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private static final String DATA_DIR = "data/";
    private static final String MASTER_FILE = "data/users.ser";
    private static Map<String, Person> users = new HashMap<>();

    static {
        new File(DATA_DIR).mkdirs();
        loadUsers();
    }

    private static void loadUsers() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(MASTER_FILE))) {
            users = (Map<String, Person>) in.readObject();
        } catch (Exception e) {
            users = new HashMap<>();
        }
    }

    private static void saveUsers() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(MASTER_FILE))) {
            out.writeObject(users);
        } catch (IOException e) {
            System.out.println("Failed to save user list.");
        }
    }

    public static boolean register(String username, String password) {
        if (users.containsKey(username)) return false;
        users.put(username, new Person(username, password));
        saveUsers();
        return true;
    }

    public static Person login(String username, String password) {
        Person user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public static void saveAll() {
        saveUsers();
    }

    public static void savePerson(Person person) {
        users.put(person.getUsername(), person);
        saveUsers();
    }
}