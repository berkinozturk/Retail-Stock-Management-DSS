import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Warehouse listesi oluşturma
        ArrayList<List<String>> warehouse = new ArrayList<>();
        warehouse.add(Arrays.asList("New Warehouse", "petlas")); // location'lar yerine tüm farklı markaları olusturup yapalım.
        warehouse.add(Arrays.asList("Old Warehouse", "petlas"));



        // Tire listesi oluşturma
        ArrayList<Tire> tires = new ArrayList<>();
        tires.add(new Tire("195/65R15", "Petlas", "summer", 50, LocalDate.of(2024, 11, 13), 50, warehouse));
        tires.add(new Tire("195/65R15", "Starmaxx", "summer", 60, LocalDate.of(2024, 11, 1), 40, warehouse));
        tires.add(new Tire("195/65R15", "Dunlop", "summer", 70, LocalDate.of(2024, 10, 5), 30, warehouse));
        tires.add(new Tire("195/65R15", "Falken", "summer", 80, LocalDate.of(2024, 9, 12), 20, warehouse));
        tires.add(new Tire("195/65R15", "Harvester", "summer", 90, LocalDate.of(2024, 8, 15), 10, warehouse));

        TireRanking tireRanking = new TireRanking(tires);
        tireRanking.rankTires();

        


        }
    }
