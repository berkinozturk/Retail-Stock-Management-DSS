import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Tire {
    private String sizeId;
    private String brand;
    private String category;
    private int salesRate; // marka ve ebatlara göre
    private LocalDate expiringDate;
    private ArrayList<List<String>> warehouse;
    private LocalDate manufactureDate;
    private double treadDepth;
    private boolean isFromFactory;
    private int numberOfTires;
    private double originalPrice; // Original price of the tire
    private double discountedPrice; // Discounted price of the tire

    public Tire(String sizeId, String brand, String category, int salesRate, LocalDate expiringDate, ArrayList<List<String>> warehouse, LocalDate manufactureDate, double treadDepth, boolean isFromFactory, int numberOfTires, double originalPrice) {
        this.sizeId = sizeId;
        this.brand = brand;
        this.category = category;
        this.salesRate = salesRate;
        this.expiringDate = expiringDate;
        this.warehouse = warehouse;
        this.manufactureDate = manufactureDate;
        this.treadDepth = treadDepth;
        this.isFromFactory = isFromFactory;
        this.numberOfTires = numberOfTires;
        this.originalPrice = originalPrice;
        this.discountedPrice = originalPrice; // Initial discounted price is the same as the original price

    }

    // Getters and Setters
    public String getSizeId() { return sizeId; }
    public void setSizeId(String sizeId) { this.sizeId = sizeId; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getSalesRate() { return salesRate; }
    public void setSalesRate(int salesRate) { this.salesRate = salesRate; }

    public LocalDate getExpiringDate() { return expiringDate; }
    public void setExpiringDate(LocalDate expiringDate) { this.expiringDate = expiringDate; }



    public ArrayList<List<String>> getWarehouse() { return warehouse; }
    public void setWarehouse(ArrayList<List<String>> warehouse) { this.warehouse = warehouse; }

    public LocalDate getManufactureDate() { return manufactureDate; }
    public void setManufactureDate(LocalDate manufactureDate) { this.manufactureDate = manufactureDate; }

    public double getTreadDepth() { return treadDepth; }
    public void setTreadDepth(double treadDepth) { this.treadDepth = treadDepth; }

    public boolean isFromFactory() { return isFromFactory; }
    public void setFromFactory(boolean fromFactory) { isFromFactory = fromFactory; }

    public int getNumberOfTires() { return numberOfTires; }
    public void setNumberOfTires(int numberOfTires) {
        this.numberOfTires = numberOfTires;
        checkOrderRequirement(); // Lastik sayısı ayarlandığında sipariş kontrolü
    }

    public double getOriginalPrice() { return originalPrice; }
    public void setOriginalPrice(double originalPrice) { this.originalPrice = originalPrice; }

    public double getDiscountedPrice() { return discountedPrice; }
    public void setDiscountedPrice(double discountedPrice) { this.discountedPrice = discountedPrice; }

    public void checkOrderRequirement() {
        if (this.numberOfTires < 12) {
            System.out.println("Order required for " + this.brand + " tires.");
        }
    }
}
