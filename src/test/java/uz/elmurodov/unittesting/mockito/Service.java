package uz.elmurodov.unittesting.mockito;

public class Service {
    private Database database;

    public Service(Database database) {
        this.database = database;
    }

    public boolean query(String query) {
        return database.isAvailable();
    }

    public String find(String name) {
        return database.findByName(name);
    }


    @Override
    public String toString() {
        return "Using database with id: " + database.getUniqueId();
    }
}
