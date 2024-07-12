import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.time.temporal.ChronoUnit;

public class TireDSS {

    public int calculateScore(Tire tire) {
        int score = 0;
        int salesRate = tire.getSalesRate();
        int numberOfTires = tire.getNumberOfTires();
        long daysToExpiry = ChronoUnit.DAYS.between(LocalDate.now(), tire.getExpiringDate());

        boolean highSalesRate = salesRate >= 60;
        boolean lowTireCount = numberOfTires < 12;
        boolean expirySoon = daysToExpiry < 30;

        if (highSalesRate && lowTireCount) {
            score += 5 * salesRate;
        }
        if (highSalesRate && lowTireCount && expirySoon) {
            score += 4 * salesRate;
        }
        if (lowTireCount && expirySoon) {
            score += 3 * salesRate;
        }
        if (lowTireCount) {
            score += 2 * salesRate;
        }
        if (expirySoon) {
            score += salesRate;
        }
        return score;
    }
}
