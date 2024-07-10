import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Warehouse listesi oluşturma
        Warehouse newWarehouse = new Warehouse("New Warehouse");
        Warehouse oldWarehouse = new Warehouse("Old Warehouse");
        Storage storage = new Storage(newWarehouse, oldWarehouse);

        ArrayList<List<String>> warehouse = new ArrayList<>();


        // Tire listesi oluşturma
        ArrayList<Tire> tires = new ArrayList<>();
        tires.add(new Tire("195/65R15", "Petlas", "summer", 50, LocalDate.of(2024, 11, 13), 50, warehouse, LocalDate.of(2024,10,13), 7.5 ));
        tires.add(new Tire("195/65R15", "Starmaxx", "summer", 60, LocalDate.of(2024, 11, 1), 40, warehouse, LocalDate.of(2024,10,13), 7.5));
        tires.add(new Tire("195/65R15", "Dunlop", "summer", 70, LocalDate.of(2024, 10, 5), 30, warehouse, LocalDate.of(2024,8,13), 6));
        tires.add(new Tire("195/65R15", "Falken", "summer", 80, LocalDate.of(2024, 9, 12), 20, warehouse, LocalDate.of(2024,10,13), 7.5));
        tires.add(new Tire("195/65R15", "Harvester", "summer", 90, LocalDate.of(2024, 8, 15), 10, warehouse, LocalDate.of(2024,10,13), 7.5));

        TireRanking tireRanking = new TireRanking(tires);
        tireRanking.rankTires();

        for (Tire tire : tires) {
            storage.storeTire(tire, false); // Assuming all tires are not from factory for this example
        }

        storage.displayWarehouses();




        }
    }
