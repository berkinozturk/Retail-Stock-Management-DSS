# Retail Stock Management DSS

## Overview
Retail Stock Management DSS is a Java-based application designed to manage tire inventories across multiple warehouses. It offers functionalities such as demand forecasting, inventory optimization, and data analysis to support decision-making in retail stock management. The project is specifically tailored for managing tire inventories across different warehouse locations. The system includes functionality for adding new tires, displaying inventory, sorting and ranking tires, checking order requirements, and applying discounts.

## Project Description in Detail
The Retail Stock Management DSS is a specialized software solution designed to streamline inventory management processes for tire retail businesses. Built using Java, this system offers comprehensive tools for tracking, analyzing, and optimizing tire stocks across multiple warehouses. The core functionalities include demand forecasting, inventory optimization, and decision support, all aimed at enhancing the efficiency of stock management and reducing associated costs.

Key features of the system include the ability to categorize and manage different types of tires (such as car, excavation, and agriculture tires), apply discounts, and determine order requirements based on current inventory levels. The user-friendly interface provides easy access to vital functions, such as adding new tires, viewing warehouse inventories, and ranking tires by various criteria. This system is essential for retail managers seeking to maintain optimal stock levels, prevent stockouts, and ensure efficient warehouse operations.

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

## Class Descriptions

### Main.java
- **Purpose**: Acts as the entry point of the application, setting up the initial data and user interface.
- **Key Methods**:
  - `main(String[] args)`: Initializes the application, creates warehouse instances, and sets up the main menu.
  - `createMainMenu()`: Creates and configures the main application window with buttons for various actions like adding tires, displaying warehouses, sorting tires, checking order requirements, and applying discounts.
  - `addInitialData()`: Populates the system with initial tire data, including different categories like car, excavation, and agriculture tires.

### Storage.java
- **Purpose**: Manages the storage and organization of tires across different warehouses.
- **Key Methods**:
  - `storeTire(Tire tire)`: Adds a tire to the appropriate warehouse based on its category.
  - `getTiresByType(String type)`: Retrieves tires based on their type (e.g., car, excavation, agriculture).
  - `applyDiscount(String type, double percentage)`: Applies a discount to all tires of a specified type.

### Tire.java
- **Purpose**: Represents a tire, including its details like model, type, price, and associated warehouse.
- **Key Methods**: Standard getters and setters for properties like `model`, `brand`, `type`, `price`, etc.

### TireDSS.java
- **Purpose**: Contains decision support logic for operations like ranking tires and checking order requirements.
- **Key Methods**:
  - `rankTires(List<Tire> tires)`: Sorts and ranks tires based on specified criteria.
  - `checkOrderRequirements(List<Tire> tires)`: Checks if more tires need to be ordered based on inventory levels.

### Warehouse.java
- **Purpose**: Represents a warehouse that stores tires.
- **Key Methods**:
  - `addTire(Tire tire)`: Adds a tire to the warehouse.
  - `removeTire(Tire tire)`: Removes a tire from the warehouse.
  - `getTires()`: Returns the list of tires stored in the warehouse.

## Project Logic
- **Initialization**: The system initializes with predefined warehouses and a set of tires categorized by their usage (car, excavation, agriculture).
- **User Interface**: The main menu provides options to add new tires, view current stock, rank tires, check if orders need to be placed, and apply discounts.
- **Inventory Management**: Tires are stored in different warehouses, and the system can retrieve, sort, and manage these tires.
- **Decision Support**: The system offers decision-making support by ranking tires based on various criteria and indicating when new stock should be ordered.

This structure allows the system to manage tire inventory efficiently, making it easier for retail managers to maintain optimal stock levels and make informed decisions about restocking and pricing.

