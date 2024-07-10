import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Tire {
    private String sizeId;
    private String name; // brand
    private String seasonType;
    private int salesRate; // marka ve ebatlara göre
    private LocalDate expiringDate;
    private int inventoryLevel; // inventory level azaldıkça haber verecek
    private ArrayList<List<String>> warehouse;
    private LocalDate manufactureDate;
    private double TreadDepth;


    public Tire(String sizeId, String name, String seasonType, int salesRate, LocalDate expiringDate, int inventoryLevel, ArrayList<List<String>> warehouse, LocalDate manufactureDate, double TreadDepth) {
        this.sizeId = sizeId;
        this.name = name;
        this.seasonType = seasonType;
        this.salesRate = salesRate;
        this.expiringDate = expiringDate;
        this.inventoryLevel = inventoryLevel;
        this.warehouse = warehouse;
        this.manufactureDate = manufactureDate;
        this.TreadDepth = TreadDepth;
    }


    public String getSizeId() { return sizeId; }
    public void setSizeId(String sizeId) { this.sizeId = sizeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSeasonType() { return seasonType; }
    public void setSeasonType(String seasonType) { this.seasonType = seasonType; }

    public int getSalesRate() { return salesRate; }
    public void setSalesRate(int salesRate) { this.salesRate = salesRate; }

    public LocalDate getExpiringDate() { return expiringDate; }
    public void setExpiringDate(LocalDate expiringDate) { this.expiringDate = expiringDate; }

    public int getInventoryLevel() { return inventoryLevel; }
    public void setInventoryLevel(int inventoryLevel) { this.inventoryLevel = inventoryLevel; }

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

}