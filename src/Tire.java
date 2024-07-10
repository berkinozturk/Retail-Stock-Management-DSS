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


    public Tire(String sizeId, String name, String seasonType, int salesRate, LocalDate expiringDate, int inventoryLevel, ArrayList<List<String>> warehouse) {
        this.sizeId = sizeId;
        this.name = name;
        this.seasonType = seasonType;
        this.salesRate = salesRate;
        this.expiringDate = expiringDate;
        this.inventoryLevel = inventoryLevel;
        this.warehouse = warehouse;
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


}