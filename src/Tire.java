import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Tire {
    private String sizeId;
    private String name; // brand
    private String category;
    private int salesRate;
    private LocalDate expiringDate;
    private ArrayList<List<String>> warehouse;
    private LocalDate manufactureDate;
    private double TreadDepth;
    private boolean isFromFactory;
    private int numberOfTires;

    public Tire(String sizeId, String name, String category, int salesRate, LocalDate expiringDate, ArrayList<List<String>> warehouse, LocalDate manufactureDate, double TreadDepth, boolean isFromFactory, int numberOfTires) {
        this.sizeId = sizeId;
        this.name = name;
        this.category = category;
        this.salesRate = salesRate;
        this.expiringDate = expiringDate;
        this.warehouse = warehouse;
        this.manufactureDate = manufactureDate;
        this.TreadDepth = TreadDepth;
        this.isFromFactory = isFromFactory;
        this.numberOfTires = numberOfTires;
    }

    public String getSizeId() { return sizeId; }
    public void setSizeId(String sizeId) { this.sizeId = sizeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getSalesRate() { return salesRate; }
    public void setSalesRate(int salesRate) { this.salesRate = salesRate; }

    public LocalDate getExpiringDate() { return expiringDate; }
    public void setExpiringDate(LocalDate expiringDate) { this.expiringDate = expiringDate; }

    public ArrayList<List<String>> getWarehouse() { return warehouse; }
    public void setWarehouse(ArrayList<List<String>> warehouse) { this.warehouse = warehouse; }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public double getTreadDepth() {
        return TreadDepth;
    }

    public void setTreadDepth(double treadDepth) {
        TreadDepth = treadDepth;
    }

    public boolean isFromFactory() {
        return isFromFactory;
    }

    public void setFromFactory(boolean fromFactory) {
        isFromFactory = fromFactory;
    }

    public int getNumberOfTires() {
        return numberOfTires;
    }

    public void setNumberOfTires(int numberOfTires) {
        this.numberOfTires = numberOfTires;
        checkOrderRequirement();
    }

    public void checkOrderRequirement(){
        if (this.numberOfTires < 12){
            System.out.println("Order required for " + this.sizeId + " " + this.name + " tires.");
        }
    }
}