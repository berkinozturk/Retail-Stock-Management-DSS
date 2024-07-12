import java.util.List;

public class TireRanking {
    private List<Tire> tires;

    public TireRanking(List<Tire> tires) {
        this.tires = tires;
    }

    public void rankTires() {
        TireDSS tireDSS = new TireDSS();
        tires.sort((t1, t2) -> tireDSS.calculateScore(t2).getTotalScore() - tireDSS.calculateScore(t1).getTotalScore());

        // Display the ranking
        for (Tire tire : tires) {
            DetailedScore score = tireDSS.calculateScore(tire);
            if (score.getTotalScore() > 0) {
                System.out.println("-----------------------------------");
                System.out.println("Tire: " + tire.getBrand() + " | Total Score: " + score.getTotalScore());
                System.out.println("  Sales Rate Contribution: " + score.getSalesRateContribution());
                System.out.println("  Sales Rate and Low Tire Count Contribution: " + score.getSalesRateAndLowTireCountContribution());
                System.out.println("  Sales Rate, Low Tire Count and Expiry Contribution: " + score.getSalesRateLowTireCountExpiryContribution());
                System.out.println("  Low Tire Count Contribution: " + score.getVeryLowTireCountContribution());
                System.out.println("  Low Tire Count and Expiry Contribution: " + score.getVeryLowTireCountAndExpiryContribution());
                System.out.println("  Expiry Soon Contribution: " + score.getExpirySoonContribution());

                if (score.getTotalScore() > 400) {
                    printTireDetails(tire);
                }
            }
        }
    }

    private void printTireDetails(Tire tire) {
        System.out.println("Tire Details:");
        System.out.println("  Size ID: " + tire.getSizeId());
        System.out.println("  Name: " + tire.getBrand());
        System.out.println("  Category: " + tire.getCategory());
        System.out.println("  Sales Rate: " + tire.getSalesRate());
        System.out.println("  Expiring Date: " + tire.getExpiringDate());
        System.out.println("  Manufacture Date: " + tire.getManufactureDate());
        System.out.println("  Tread Depth: " + tire.getTreadDepth());
        System.out.println("  Is From Factory: " + tire.isFromFactory());
        System.out.println("  Number of Tires: " + tire.getNumberOfTires());

    }
}
