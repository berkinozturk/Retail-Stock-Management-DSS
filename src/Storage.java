import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Storage {

    private final Warehouse carNewWarehouse;
    private final Warehouse carOldWarehouse;
    private final Warehouse excavationNewWarehouse;
    private final Warehouse excavationOldWarehouse;
    private final Warehouse agriculturalNewWarehouse;
    private final Warehouse agriculturalOldWarehouse;

    public Storage(Warehouse carNewWarehouse, Warehouse carOldWarehouse, Warehouse excavationNewWarehouse, Warehouse excavationOldWarehouse, Warehouse agriculturalNewWarehouse, Warehouse agriculturalOldWarehouse) {
        this.carNewWarehouse = carNewWarehouse;
        this.carOldWarehouse = carOldWarehouse;
        this.excavationNewWarehouse = excavationNewWarehouse;
        this.excavationOldWarehouse = excavationOldWarehouse;
        this.agriculturalNewWarehouse = agriculturalNewWarehouse;
        this.agriculturalOldWarehouse = agriculturalOldWarehouse;
    }

    public void storeTire(Tire tire) {
        long daysSinceManufacture = ChronoUnit.DAYS.between(tire.getManufactureDate(), LocalDate.now());
        boolean isNew = tire.isFromFactory() || (tire.getTreadDepth() >= 7 && daysSinceManufacture <= 30);

        if (tire.getCategory().equals("car")) {
            if (isNew) {
                carNewWarehouse.addTire(tire);
            } else {
                carOldWarehouse.addTire(tire);
            }
        } else if (tire.getCategory().equals("excavation")) {
            if (isNew) {
                excavationNewWarehouse.addTire(tire);
            } else {
                excavationOldWarehouse.addTire(tire);
            }
        } else if (tire.getCategory().equals("agriculture")) {
            if (isNew) {
                agriculturalNewWarehouse.addTire(tire);
            } else {
                agriculturalOldWarehouse.addTire(tire);
            }
        }
    }

    public void displayWarehouses() {

        System.out.println("NEW CAR WAREHOUSE:");
        carNewWarehouse.getAllTires().forEach((brand, tires) -> {
            System.out.println("Brand: " + brand);
            tires.forEach(tire -> System.out.println(" - The size Id: " + tire.getSizeId() + " & Manufacturing Date: " + tire.getManufactureDate() + " & Number of Tires: " + tire.getNumberOfTires()));
        });

        System.out.println("\nOLD CAR WAREHOUSE:");
        carOldWarehouse.getAllTires().forEach((brand, tires) -> {
            System.out.println("Brand: " + brand);
            tires.forEach(tire -> System.out.println(" - The size Id: " + tire.getSizeId() + " & Manufacturing Date: " + tire.getManufactureDate() + " & Number of Tires: " + tire.getNumberOfTires()));
        });

        System.out.println("\nNEW EXCAVATION WAREHOUSE:");
        excavationNewWarehouse.getAllTires().forEach((brand, tires) -> {
            System.out.println("Brand: " + brand);
            tires.forEach(tire -> System.out.println(" - The size Id: " + tire.getSizeId() + " & Manufacturing Date: " + tire.getManufactureDate() + " & Number of Tires: " + tire.getNumberOfTires()));
        });

        System.out.println("\nOLD EXCAVATION WAREHOUSE:");
        excavationOldWarehouse.getAllTires().forEach((brand, tires) -> {
            System.out.println("Brand: " + brand);
            tires.forEach(tire -> System.out.println(" - The size Id: " + tire.getSizeId() + " & Manufacturing Date: " + tire.getManufactureDate() + " & Number of Tires: " + tire.getNumberOfTires()));
        });

        System.out.println("\nNEW AGRICULTURE WAREHOUSE:");
        agriculturalNewWarehouse.getAllTires().forEach((brand, tires) -> {
            System.out.println("Brand: " + brand);
            tires.forEach(tire -> System.out.println(" - The size Id: " + tire.getSizeId() + " & Manufacturing Date: " + tire.getManufactureDate() + " & Number of Tires: " + tire.getNumberOfTires()));
        });

        System.out.println("\nOLD AGRICULTURE WAREHOUSE:");
        agriculturalOldWarehouse.getAllTires().forEach((brand, tires) -> {
            System.out.println("Brand: " + brand);
            tires.forEach(tire -> System.out.println(" - The size Id: " + tire.getSizeId() + " & Manufacturing Date: " + tire.getManufactureDate() + " & Number of Tires: " + tire.getNumberOfTires()));
        });
    }
}
