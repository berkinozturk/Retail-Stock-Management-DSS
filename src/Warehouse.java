import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Warehouse {

    private String name;
    private Map<String, List<Tire>> tires;

    public Warehouse(String name) {
        this.name = name;
        this.tires = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addTire(Tire tire) {
        tires.computeIfAbsent(tire.getName(), k -> new ArrayList<>()).add(tire);
    }

    public List<Tire> getTires(String brand) {
        return tires.getOrDefault(brand, new ArrayList<>());
    }

    public Map<String, List<Tire>> getAllTires() {
        return tires;
    }
}
