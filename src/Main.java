import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Tire> tires = new ArrayList<>();
    private static Storage storage;


    public static void main(String[] args) {
        // Warehouse list
        Warehouse newCarWarehouse = new Warehouse("New Car Warehouse");
        Warehouse oldCarWarehouse = new Warehouse("Old Car Warehouse");
        Warehouse newExcavationWarehouse = new Warehouse("New Excavation Warehouse");
        Warehouse oldExcavationWarehouse = new Warehouse("Old Excavation Warehouse");
        Warehouse newAgricultureWarehouse = new Warehouse("New Agriculture Warehouse");
        Warehouse oldAgricultureWarehouse = new Warehouse("Old Agriculture Warehouse");
        storage = new Storage(newCarWarehouse, oldCarWarehouse, newExcavationWarehouse, oldExcavationWarehouse, newAgricultureWarehouse, oldAgricultureWarehouse);

        addInitialData();

        while (true) {
            System.out.println("1. Add Tire");
            System.out.println("2. Show Warehouses");
            System.out.println("3. Sort and Show Tires");
            System.out.println("4. Check Order Requirements");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTire();
                    break;
                case 2:
                    storage.displayWarehouses();
                    break;
                case 3:
                    rankAndDisplayTires();
                    break;
                case 4:
                    checkOrderRequirements();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    private static void addTire() {
        System.out.print("Size ID: ");
        String sizeId = scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Category (car/excavation/agriculture): ");
        String category = scanner.nextLine();
        System.out.print("Sales Rate: ");
        int salesRate = scanner.nextInt();
        scanner.nextLine();
        LocalDate expiringDate = readDate("Expiring Date (YYYY-MM-DD): ");
        ArrayList<List<String>> warehouse = new ArrayList<>();
        LocalDate manufactureDate = readDate("Manufacture Date (YYYY-MM-DD): ");
        System.out.print("Tread Depth: ");
        double treadDepth = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Is From Factory (true/false): ");
        boolean isFromFactory = scanner.nextBoolean();
        System.out.print("Number of Tires: ");
        int numberOfTires = scanner.nextInt();
        scanner.nextLine();

        Tire tire = new Tire(sizeId, name, category, salesRate, expiringDate, warehouse, manufactureDate, treadDepth, isFromFactory, numberOfTires);
        tires.add(tire);
        storage.storeTire(tire);
        System.out.println("The tire has been successfully added and stored.");
    }

    private static LocalDate readDate(String prompt) {
        LocalDate date = null;
        while (date == null) {
            System.out.print(prompt);
            String dateString = scanner.nextLine();
            try {
                date = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please try again.");
            }
        }
        return date;
    }

    private static void rankAndDisplayTires() {
        TireRanking tireRanking = new TireRanking(tires);
        tireRanking.rankTires();
    }

    private static void checkOrderRequirements() {
        for (Tire tire : tires) {
            tire.checkOrderRequirement();
        }
    }

    private static void addInitialData() {
        ArrayList<List<String>> warehouse = new ArrayList<>();

        // Car tires list
        tires.add(new Tire("1", "Petlas", "car", 50, LocalDate.of(2024, 11, 13), warehouse, LocalDate.of(2024,10,13), 7.5 ,true,4));
        tires.add(new Tire("2", "Starmaxx", "car", 60, LocalDate.of(2024, 11, 1), warehouse, LocalDate.of(2024,10,13), 7.5,true,4));
        tires.add(new Tire("3", "Starmaxx", "car", 60, LocalDate.of(2024, 11, 1), warehouse, LocalDate.of(2024,10,13), 7.5,true,4));
        tires.add(new Tire("4", "Dunlop", "car", 70, LocalDate.of(2024, 10, 5), warehouse, LocalDate.of(2024,8,13), 6,false, 20));
        tires.add(new Tire("5", "Falken", "car", 80, LocalDate.of(2024, 9, 12), warehouse, LocalDate.of(2024,10,13), 7.5, false, 20));
        tires.add(new Tire("6", "Harvester", "car", 90, LocalDate.of(2024, 8, 15), warehouse, LocalDate.of(2024,10,13), 7.5, false, 20));

        // Excavation tires list
        tires.add(new Tire("7", "Michelin", "excavation", 80, LocalDate.of(2024, 8, 20), warehouse, LocalDate.of(2024, 6, 15), 8.0, false, 15)); // Kamyon
        tires.add(new Tire("8", "Bridgestone", "excavation", 70, LocalDate.of(2024, 8, 25), warehouse, LocalDate.of(2024, 5, 10), 7.5, false, 10)); // Kepçe
        tires.add(new Tire("9", "Goodyear", "excavation", 60, LocalDate.of(2024, 7, 30),  warehouse, LocalDate.of(2024, 5, 15), 7.0, false, 12)); // Forklift
        tires.add(new Tire("10", "Pirelli", "excavation", 50, LocalDate.of(2024, 6, 20),  warehouse, LocalDate.of(2024, 4, 20), 6.5, false, 20)); // Vinç

        // Agriculture tires list
        tires.add(new Tire("11", "Firestone", "agriculture", 85, LocalDate.of(2025, 10, 1),  warehouse, LocalDate.of(2024, 9, 15), 8.5, false, 25)); // Biçerdöver
        tires.add(new Tire("12", "Trelleborg", "agriculture", 75, LocalDate.of(2025, 9, 20),  warehouse, LocalDate.of(2024, 8, 20), 8.0, false, 18)); // Traktör
        tires.add(new Tire("13", "Continental", "agriculture", 65, LocalDate.of(2025, 8, 15),  warehouse, LocalDate.of(2024, 7, 10), 6, false, 22)); // Römork

        // Add tires to warehouse
        for (Tire tire : tires) {
            storage.storeTire(tire);
        }
    }

    //TODO:
    // depoların içerisinde discount'a uğrayacak lastikleri yazdır.
    // satış oranı düşük ürünleri discount'a direkt bağlayabiliriz. ve onları yazdırabiliriz.
    // Asıl fiyatı şuydu, ama sizin her şeyi göz önünde bulundurarak koymanız gereken fiyat şu: gibisinden
    // skor sıralamasında hangi skorun nerden geldiğini göstermek?
    // bu amk skorları ile ne yapılacak --> bilgilere göre farkli islemler: tarih azsa discount'a uğrat. teker sayısız az ise direkt sipariş ver.
    // arayüz yap.
    // name --> brand olacak
    // COMPLETED 0 score olanlar gösterilmiyor sadece ihtiyaç listesi olanlar gözüküyor

}
