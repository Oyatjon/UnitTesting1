package uz.elmurodov.unittesting.mockito;

public class Database {

    public boolean isAvailable() {
        return false;
    }

    public int getUniqueId() {
        return 42;
    }

    public String findByName(String name) {
        if (name.equalsIgnoreCase("asliddin")) {
            throw new RuntimeException("Romances is not allowed to hit this method 🤣");
        }
        return "Here we are";
    }
}
