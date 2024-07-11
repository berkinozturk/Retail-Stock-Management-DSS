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
        // Warehouse listesi oluşturma
        Warehouse newCarWarehouse = new Warehouse("New Car Warehouse");
        Warehouse oldCarWarehouse = new Warehouse("Old Car Warehouse");
        Warehouse newExcavationWarehouse = new Warehouse("New Excavation Warehouse");
        Warehouse oldExcavationWarehouse = new Warehouse("Old Excavation Warehouse");
        Warehouse newAgricultureWarehouse = new Warehouse("New Agriculture Warehouse");
        Warehouse oldAgricultureWarehouse = new Warehouse("Old Agriculture Warehouse");
        storage = new Storage(newCarWarehouse, oldCarWarehouse, newExcavationWarehouse, oldExcavationWarehouse, newAgricultureWarehouse, oldAgricultureWarehouse);

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
        System.out.print("Season Type (car/excavation/agriculture): ");
        String seasonType = scanner.nextLine();
        System.out.print("Sales Rate: ");
        int salesRate = scanner.nextInt();
        scanner.nextLine();
        LocalDate expiringDate = readDate("Expiring Date (YYYY-MM-DD): ");
        System.out.print("Inventory Level: ");
        int inventoryLevel = scanner.nextInt();
        scanner.nextLine();
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

        Tire tire = new Tire(sizeId, name, seasonType, salesRate, expiringDate, inventoryLevel, warehouse, manufactureDate, treadDepth, isFromFactory, numberOfTires);
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
}
