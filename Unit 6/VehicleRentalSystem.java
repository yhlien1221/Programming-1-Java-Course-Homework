import java.util.Scanner;


// Vehicle Interface
// This interface defines the contract for all vehicles, ensuring consistency across different vehicle types.
interface Vehicle {
    String getMake(); // Method to retrieve the vehicle's make
    String getModel(); // Method to retrieve the vehicle's model
    int getYear(); // Method to retrieve the vehicle's year of manufacture
}


// CarVehicle Interface
// This interface extends the behavior for cars, adding methods specific to car attributes.
interface CarVehicle {
    void setNumberOfDoors(int doors); // Method to set the number of doors
    int getNumberOfDoors(); // Method to retrieve the number of doors


    void setFuelType(String fuelType); // Method to set the fuel type (petrol, diesel, electric)
    String getFuelType(); // Method to retrieve the fuel type
}


// MotorVehicle Interface
// This interface extends the behavior for motorcycles, adding methods specific to motorcycle attributes.
interface MotorVehicle {
    void setNumberOfWheels(int wheels); // Method to set the number of wheels
    int getNumberOfWheels(); // Method to retrieve the number of wheels


    void setTypeOfMotorcycle(String type); // Method to set the type of motorcycle
    String getTypeOfMotorcycle(); // Method to retrieve the type of motorcycle
}


// TruckVehicle Interface
// This interface extends the behavior for trucks, adding methods specific to truck attributes.
interface TruckVehicle {
    void setCargoCapacity(double cargoCapacity); // Method to set cargo capacity in tons
    double getCargoCapacity(); // Method to retrieve cargo capacity


    void setTransmissionType(String transmissionType); // Method to set transmission type (manual/automatic)
    String getTransmissionType(); // Method to retrieve transmission type
}


// Car Class
// Implements the Vehicle and CarVehicle interfaces, providing concrete behavior for cars.
class Car implements Vehicle, CarVehicle {
    private String make; // Vehicle make
    private String model; // Vehicle model
    private int year; // Vehicle year of manufacture
    private int numberOfDoors; // Number of doors
    private String fuelType; // Fuel type


    // Constructor to initialize the basic details of a car
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }


    // Implement methods from Vehicle interface
    @Override
    public String getMake() {
        return make;
    }


    @Override
    public String getModel() {
        return model;
    }


    @Override
    public int getYear() {
        return year;
    }


    // Implement methods from CarVehicle interface
    @Override
    public void setNumberOfDoors(int doors) {
        this.numberOfDoors = doors;
    }


    @Override
    public int getNumberOfDoors() {
        return numberOfDoors;
    }


    @Override
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }


    @Override
    public String getFuelType() {
        return fuelType;
    }
}


// Motorcycle Class
// Implements the Vehicle and MotorVehicle interfaces, providing concrete behavior for motorcycles.
class Motorcycle implements Vehicle, MotorVehicle {
    private String make; // Vehicle make
    private String model; // Vehicle model
    private int year; // Vehicle year of manufacture
    private int numberOfWheels; // Number of wheels
    private String typeOfMotorcycle; // Type of motorcycle


    // Constructor to initialize the basic details of a motorcycle
    public Motorcycle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }


    // Implement methods from Vehicle interface
    @Override
    public String getMake() {
        return make;
    }


    @Override
    public String getModel() {
        return model;
    }


    @Override
    public int getYear() {
        return year;
    }


    // Implement methods from MotorVehicle interface
    @Override
    public void setNumberOfWheels(int wheels) {
        this.numberOfWheels = wheels;
    }


    @Override
    public int getNumberOfWheels() {
        return numberOfWheels;
    }


    @Override
    public void setTypeOfMotorcycle(String type) {
        this.typeOfMotorcycle = type;
    }


    @Override
    public String getTypeOfMotorcycle() {
        return typeOfMotorcycle;
    }
}


// Truck Class
// Implements the Vehicle and TruckVehicle interfaces, providing concrete behavior for trucks.
class Truck implements Vehicle, TruckVehicle {
    private String make; // Vehicle make
    private String model; // Vehicle model
    private int year; // Vehicle year of manufacture
    private double cargoCapacity; // Cargo capacity in tons
    private String transmissionType; // Transmission type


    // Constructor to initialize the basic details of a truck
    public Truck(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }


    // Implement methods from Vehicle interface
    @Override
    public String getMake() {
        return make;
    }


    @Override
    public String getModel() {
        return model;
    }


    @Override
    public int getYear() {
        return year;
    }


    // Implement methods from TruckVehicle interface
    @Override
    public void setCargoCapacity(double cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }


    @Override
    public double getCargoCapacity() {
        return cargoCapacity;
    }


    @Override
    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }


    @Override
    public String getTransmissionType() {
        return transmissionType;
    }
}


// Main Program
// This program allows users to interactively create vehicle objects and display their details.
public class VehicleRentalSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Choose a vehicle type to create (Car, Motorcycle, Truck):");
        String vehicleType = scanner.nextLine();


        // Create Car object
        if (vehicleType.equalsIgnoreCase("Car")) {
            System.out.println("Enter Car make, model, and year:");
            String make = scanner.nextLine();
            String model = scanner.nextLine();
            int year = scanner.nextInt();
            scanner.nextLine();


            Car car = new Car(make, model, year);
            System.out.println("Enter number of doors:");
            car.setNumberOfDoors(scanner.nextInt());
            scanner.nextLine();


            System.out.println("Enter fuel type (Petrol, Diesel, Electric):");
            car.setFuelType(scanner.nextLine());


            System.out.printf("Car Details: Make: %s, Model: %s, Year: %d, Doors: %d, Fuel: %s\n",
                    car.getMake(), car.getModel(), car.getYear(), car.getNumberOfDoors(), car.getFuelType());
        }


        // Create Motorcycle object
        else if (vehicleType.equalsIgnoreCase("Motorcycle")) {
            System.out.println("Enter Motorcycle make, model, and year:");
            String make = scanner.nextLine();
            String model = scanner.nextLine();
            int year = scanner.nextInt();
            scanner.nextLine();


            Motorcycle motorcycle = new Motorcycle(make, model, year);
            System.out.println("Enter number of wheels:");
            motorcycle.setNumberOfWheels(scanner.nextInt());
            scanner.nextLine();


            System.out.println("Enter type of motorcycle (Sport, Cruiser, Off-road):");
            motorcycle.setTypeOfMotorcycle(scanner.nextLine());


            System.out.printf("Motorcycle Details: Make: %s, Model: %s, Year: %d, Wheels: %d, Type: %s\n",
                    motorcycle.getMake(), motorcycle.getModel(), motorcycle.getYear(),
                    motorcycle.getNumberOfWheels(), motorcycle.getTypeOfMotorcycle());
        }


        // Create Truck object
        else if (vehicleType.equalsIgnoreCase("Truck")) {
            System.out.println("Enter Truck make, model, and year:");
            String make = scanner.nextLine();
            String model = scanner.nextLine();
            int year = scanner.nextInt();
            scanner.nextLine();


            Truck truck = new Truck(make, model, year);
            System.out.println("Enter cargo capacity (in tons):");
            truck.setCargoCapacity(scanner.nextDouble());
            scanner.nextLine();


            System.out.println("Enter transmission type (Manual, Automatic):");
            truck.setTransmissionType(scanner.nextLine());


            System.out.printf("Truck Details: Make: %s, Model: %s, Year: %d, Cargo Capacity: %.1f tons, Transmission: %s\n",
                    truck.getMake(), truck.getModel(), truck.getYear(), truck.getCargoCapacity(), truck.getTransmissionType());
        }


        // Handle invalid vehicle type
        else {
            System.out.println("Invalid vehicle type. Please choose Car, Motorcycle, or Truck.");
        }


        scanner.close(); // Close the scanner
    }
}
