
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GenericRepository<T> {

    private final Map<Integer, T> data = new LinkedHashMap<>();

    // Create
    public void save(int id, T item) {
        data.put(id, item);
    }

    // Read one object
    public T findById(int id) {
        return data.get(id);
    }

    // Read all objects
    public List<T> findAll() {
        return new ArrayList<>(data.values());
    }

    // Update
    public boolean update(int id, T item) {
        if (!data.containsKey(id)) {
            return false;
        }

        data.put(id, item);
        return true;
    }

    // Delete
    public boolean delete(int id) {
        return data.remove(id) != null;
    }

    // Display all objects
    public void displayAll() {
        for (Map.Entry<Integer, T> entry : data.entrySet()) {
            System.out.println(
                "ID: " + entry.getKey()
                + ", Data: " + entry.getValue()
            );
        }
    }
}
