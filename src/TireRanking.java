import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TireRanking {

    private List<Tire> tires;

    // Constructor
    public TireRanking(List<Tire> tires) {
        this.tires = tires;
    }


    public void rankTires() {
        TireDSS tireDSS = new TireDSS();

        tires.sort((t1, t2) -> tireDSS.calculateScore(t2) - tireDSS.calculateScore(t1));

        // Display the ranking
        for (Tire tire : tires) {
            int score = tireDSS.calculateScore(tire);
            System.out.println("Tire: " + tire.getName() + " | Score: " +score);
            if (score > 400){
                System.out.println("----------------");
                printTireDetails(tire);
                System.out.println("----------------");
            }
        }

    }

    private void printTireDetails(Tire tire) {
        System.out.println("Tire Details:");
        System.out.println("Size ID: " + tire.getSizeId());
        System.out.println("Name: " + tire.getName());
        System.out.println("Season Type: " + tire.getSeasonType());
        System.out.println("Sales Rate: " + tire.getSalesRate());
        System.out.println("Expiring Date: " + tire.getExpiringDate());
        System.out.println("Inventory Level: " + tire.getInventoryLevel());
        System.out.println("Manufacture Date: " + tire.getManufactureDate());
        System.out.println("Tread Depth: " + tire.getTreadDepth());
        System.out.println("Is From Factory: " + tire.isFromFactory());
        System.out.println("Number of Tires: " + tire.getNumberOfTires());
    }
}

