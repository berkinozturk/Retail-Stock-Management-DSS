import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Storage {

    private Warehouse newWarehouse;
    private Warehouse oldWarehouse;

    public Storage(Warehouse newWarehouse, Warehouse oldWarehouse) {
        this.newWarehouse = newWarehouse;
        this.oldWarehouse = oldWarehouse;
    }

    public void storeTire(Tire tire, boolean isFromFactory) {
        if (isFromFactory) {
            newWarehouse.addTire(tire);
        } else {
            long daysSinceManufacture = ChronoUnit.DAYS.between(tire.getManufactureDate(), LocalDate.now());
            if (tire.getTreadDepth() < 7 || daysSinceManufacture > 30) {
                oldWarehouse.addTire(tire);
            } else {
                newWarehouse.addTire(tire);
            }
        }
    }

    public void displayWarehouses() {
        System.out.println("New Warehouse:");
        newWarehouse.getAllTires().forEach((brand, tires) -> {
            System.out.println("Brand: " + brand);
            tires.forEach(tire -> System.out.println(" - " + tire.getSizeId()));
        });

        System.out.println("\nOld Warehouse:");
        oldWarehouse.getAllTires().forEach((brand, tires) -> {
            System.out.println("Brand: " + brand);
            tires.forEach(tire -> System.out.println(" - " + tire.getSizeId()));
        });
    }
}
