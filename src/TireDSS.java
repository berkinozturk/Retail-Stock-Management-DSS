import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TireDSS {

    public DetailedScore calculateScore(Tire tire) {
        int totalScore = 0;
        int salesRate = tire.getSalesRate();
        int numberOfTires = tire.getNumberOfTires();
        long daysToExpiry = ChronoUnit.DAYS.between(LocalDate.now(), tire.getExpiringDate());

        boolean highSalesRate = salesRate > 60;
        boolean lowTireCount = numberOfTires < 12;
        boolean expirySoon = daysToExpiry < 30;

        int salesRateContribution = 0;
        int salesRateAndLowTireCountContribution = 0;
        int salesRateLowTireCountExpiryContribution = 0;
        int lowTireCountContribution = 0;
        int lowTireCountAndExpiryContribution = 0;
        int expirySoonContribution = 0;

        // Katsayılar ile puanlama
        if (highSalesRate && lowTireCount) {
            salesRateAndLowTireCountContribution = 5 * salesRate;
            totalScore += salesRateAndLowTireCountContribution;
        }
        if (highSalesRate && lowTireCount && expirySoon) {
            salesRateLowTireCountExpiryContribution = 4 * salesRate;
            totalScore += salesRateLowTireCountExpiryContribution;
        }
        if (lowTireCount && expirySoon) {
            lowTireCountAndExpiryContribution = 3 * salesRate;
            totalScore += lowTireCountAndExpiryContribution;
        }
        if (lowTireCount) {
            lowTireCountContribution = 2 * salesRate;
            totalScore += lowTireCountContribution;
        }
        if (expirySoon) {
            expirySoonContribution = 1 * salesRate;
            totalScore += expirySoonContribution;
        }

        return new DetailedScore(
                totalScore,
                salesRateContribution,
                salesRateAndLowTireCountContribution,
                salesRateLowTireCountExpiryContribution,
                lowTireCountContribution,
                lowTireCountAndExpiryContribution,
                expirySoonContribution
        );
    }
}

class DetailedScore {
    private int totalScore;
    private int salesRateContribution;
    private int salesRateAndLowTireCountContribution;
    private int salesRateLowTireCountExpiryContribution;
    private int veryLowTireCountContribution;
    private int veryLowTireCountAndExpiryContribution;
    private int expirySoonContribution;

    public DetailedScore(
            int totalScore,
            int salesRateContribution,
            int salesRateAndLowTireCountContribution,
            int salesRateLowTireCountExpiryContribution,
            int veryLowTireCountContribution,
            int veryLowTireCountAndExpiryContribution,
            int expirySoonContribution) {
        this.totalScore = totalScore;
        this.salesRateContribution = salesRateContribution;
        this.salesRateAndLowTireCountContribution = salesRateAndLowTireCountContribution;
        this.salesRateLowTireCountExpiryContribution = salesRateLowTireCountExpiryContribution;
        this.veryLowTireCountContribution = veryLowTireCountContribution;
        this.veryLowTireCountAndExpiryContribution = veryLowTireCountAndExpiryContribution;
        this.expirySoonContribution = expirySoonContribution;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getSalesRateContribution() {
        return salesRateContribution;
    }

    public int getSalesRateAndLowTireCountContribution() {
        return salesRateAndLowTireCountContribution;
    }

    public int getSalesRateLowTireCountExpiryContribution() {
        return salesRateLowTireCountExpiryContribution;
    }

    public int getVeryLowTireCountContribution() {
        return veryLowTireCountContribution;
    }

    public int getVeryLowTireCountAndExpiryContribution() {
        return veryLowTireCountAndExpiryContribution;
    }

    public int getExpirySoonContribution() {
        return expirySoonContribution;
    }
}
