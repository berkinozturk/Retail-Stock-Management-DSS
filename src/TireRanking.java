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
            System.out.println("Tire: " + tire.getName() + " | Score: " + tireDSS.calculateScore(tire));
        }
    }
}

