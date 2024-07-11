import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Warehouse list
        Warehouse newCarWarehouse = new Warehouse("New Car Warehouse");
        Warehouse oldCarWarehouse = new Warehouse("Old Car Warehouse");
        Warehouse newExcavationWarehouse = new Warehouse("New Excavation Warehouse");
        Warehouse oldExcavationWarehouse = new Warehouse("Old Excavation Warehouse");
        Warehouse newAgricultureWarehouse = new Warehouse("New Agriculture Warehouse");
        Warehouse oldAgricultureWarehouse = new Warehouse("Old Agriculture Warehouse");
        Storage storage = new Storage(newCarWarehouse, oldCarWarehouse, newExcavationWarehouse, oldExcavationWarehouse, newAgricultureWarehouse, oldAgricultureWarehouse);

        ArrayList<List<String>> warehouse = new ArrayList<>();


        // Tire list
        ArrayList<Tire> tires = new ArrayList<>();
        tires.add(new Tire("1", "Petlas", "car", 50, LocalDate.of(2024, 11, 13), 50, warehouse, LocalDate.of(2024,10,13), 7.5 ,true,4));
        tires.add(new Tire("2", "Starmaxx", "car", 60, LocalDate.of(2024, 11, 1), 40, warehouse, LocalDate.of(2024,10,13), 7.5,true,4));
        tires.add(new Tire("3", "Starmaxx", "car", 60, LocalDate.of(2024, 11, 1), 40, warehouse, LocalDate.of(2024,10,13), 7.5,true,4));
        tires.add(new Tire("3.5", "Starmaxx", "car", 60, LocalDate.of(2024, 11, 1), 40, warehouse, LocalDate.of(2024,10,13), 6,false,4));
        tires.add(new Tire("4", "Dunlop", "car", 70, LocalDate.of(2024, 10, 5), 30, warehouse, LocalDate.of(2024,8,13), 6,false, 20));
        tires.add(new Tire("5", "Falken", "car", 80, LocalDate.of(2024, 9, 12), 20, warehouse, LocalDate.of(2024,10,13), 7.5, false, 20));
        tires.add(new Tire("6", "Harvester", "car", 90, LocalDate.of(2024, 8, 15), 10, warehouse, LocalDate.of(2024,10,13), 7.5, false, 20));

        // Excavation tires list
        tires.add(new Tire("235/75R17.5", "Michelin", "excavation", 80, LocalDate.of(2024, 8, 20), 30, warehouse, LocalDate.of(2024, 6, 15), 8.0, false, 15)); // Kamyon
        tires.add(new Tire("215/75R17.5", "Bridgestone", "excavation", 70, LocalDate.of(2024, 8, 25), 20, warehouse, LocalDate.of(2024, 5, 10), 7.5, false, 10)); // Kepçe
        tires.add(new Tire("225/75R17.5", "Goodyear", "excavation", 60, LocalDate.of(2024, 7, 30), 25, warehouse, LocalDate.of(2024, 5, 15), 7.0, false, 12)); // Forklift
        tires.add(new Tire("245/75R17.5", "Pirelli", "excavation", 50, LocalDate.of(2024, 6, 20), 35, warehouse, LocalDate.of(2024, 4, 20), 6.5, false, 20)); // Vinç

        // Agriculture tires list
        tires.add(new Tire("480/70R34", "Firestone", "agriculture", 85, LocalDate.of(2025, 10, 1), 30, warehouse, LocalDate.of(2024, 9, 15), 8.5, false, 25)); // Biçerdöver
        tires.add(new Tire("320/85R28", "Trelleborg", "agriculture", 75, LocalDate.of(2025, 9, 20), 40, warehouse, LocalDate.of(2024, 8, 20), 8.0, false, 18)); // Traktör
        tires.add(new Tire("400/70R24", "Continental", "agriculture", 65, LocalDate.of(2025, 8, 15), 50, warehouse, LocalDate.of(2024, 7, 10), 7.5, false, 22)); // Römork

        TireRanking tireRanking = new TireRanking(tires);
        tireRanking.rankTires();

        for (Tire tire : tires) {
            storage.storeTire(tire);
        }
        storage.displayWarehouses();


        System.out.println();
        System.out.println("Checking for order requirement...");
        for (Tire tire : tires) {
            tire.checkOrderRequirement();
        }


        // TO DO:
        // input olarak vermek icin bi sistem yarat.
        // COMPLETED traktör , harfiyat lastikleri
        // COMPLETED warehouse'ların hepsinde id ile beraber tarihleri de göster
        // COMPLETED lastiklerin ne zaman siparis edilmesi gerek? 12'nin altına dustugunde siparis verilmesi gerekiyo diye output cıkacak.
        // COMPLETED adet diye bir attr. yarat ve ona göre skor sıstemı yarat
        // COMPLETED skor 400 un uzerındeyse lastık bılgılerını getır.
        // COMPLETED 2 warehouse da gıdecek lastıkler tarıhlerıne gore.

        }
    }
