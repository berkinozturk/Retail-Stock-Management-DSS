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

        return score;
    }
}
