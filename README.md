# Retail Stock Management DSS

## Overview
Retail Stock Management DSS is a Java-based application designed to manage tire inventories across multiple warehouses. It offers functionalities such as demand forecasting, inventory optimization, and data analysis to support decision-making in retail stock management.

## Features
- **Demand Forecasting**: Predict future tire demand based on historical data.
- **Inventory Optimization**: Suggest optimal inventory levels to minimize costs and prevent stockouts.
- **Data Analysis**: Analyze and visualize inventory data, including sales trends and tire rankings.
- **Order Management**: Check order requirements based on current inventory levels.
- **Discount Application**: Apply and manage discounts on tire inventory.

## Installation
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/berkinozturk/Retail-Stock-Management-DSS.git
   ```

2. **Build the Project**:
   Navigate to the project directory and build using Maven:
    ```bash
    cd Retail-Stock-Management-DSS
    mvn clean install
   ```
3. **Run the Application**:
    ```bash
   java -jar target/Retail-Stock-Management-DSS.jar
    ```


## Usage
- **Add New Tire**: Enter details of new tires to be added to the inventory.
- **View Warehouses**: Display the list of warehouses and their stored tires.
- **Sort and Show Tires**: Rank tires based on criteria such as brand, type, and price.
- **Check Order Requirements**: Determine if additional tires need to be ordered.
- **Apply and Show Discount**: Apply discounts to tires and display the updated prices.

## Class Structure and Logic

### 1. Main.java
- **Description**: Initializes the application and sets up the main menu interface.
- **Key Functions**: createMainMenu(), addInitialData()
### 2. Storage.java
- **Description**: Manages tire storage and operations across multiple warehouses.
- **Key Functions**: storeTire(Tire tire), getTiresByType(String type), applyDiscount(String type, double percentage)
### 3. Tire.java
- **Description**: Represents a tire with attributes such as model, brand, type, price, and associated warehouse.
- **Key Functions**: Standard getters and setters for tire properties.
### 4. TireDSS.java
- **Description**: Provides decision support functionalities like tire ranking and order requirement checks.
- **Key Functions**: rankTires(List<Tire> tires), checkOrderRequirements(List<Tire> tires)
### 5. Warehouse.java
- **Description**: Represents a warehouse entity that stores tires.
- **Key Function**s: addTire(Tire tire), removeTire(Tire tire), getTires()
