import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.time.temporal.ChronoUnit;

public class TireDSS {

    public int calculateScore(Tire tire) {
        int score = 0;

        // Higher sales rate contributes positively to the score
        score += tire.getSalesRate() * 2;

        // Lower inventory levels contribute positively to the score (urgency for restock)
        score += (100 - tire.getInventoryLevel()) * 3;

        // Tires closer to expiring contribute positively to the score
        long daysToExpiry = ChronoUnit.DAYS.between(LocalDate.now(), tire.getExpiringDate());
        if (daysToExpiry < 30) {
            score += (30 - daysToExpiry) * 2;  // Higher score for items closer to expiry
        }

        // Number of tires stock level contributes to the score
        int numberOfTires = tire.getNumberOfTires();
        if (numberOfTires < 10) {
            score += 50; // Highest urgency
        } else if (numberOfTires < 20) {
            score += 40;
        } else if (numberOfTires < 30) {
            score += 30;
        } else if (numberOfTires < 40) {
            score += 20;
        } else if (numberOfTires < 50) {
            score += 10; // Lowest urgency
        }
        return score;
    }
}
