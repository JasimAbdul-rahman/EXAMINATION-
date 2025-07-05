import java.util.UUID;
public class Vehicle {

    public enum VehicleType {
        TAXI, SHUTTLE
    }

    public enum VehicleStatus {
        AVAILABLE, EN_ROUTE_TO_PICKUP, TRANSPORTING_PASSENGERS, AT_PICKUP_LOCATION
    }

    private final String vehicleId;
    private final VehicleType type;
    private final int capacity; 
    private VehicleStatus status;
    private Location currentLocation; 

   
    public Vehicle(VehicleType type, int capacity) {
        this.vehicleId = UUID.randomUUID().toString().substring(0, 8); 
        this.type = type;
        this.capacity = capacity;
        this.status = VehicleStatus.AVAILABLE; 
        this.currentLocation = new Location(0, 0); 
    }

   
    public String getVehicleId() {
        return vehicleId;
    }

  
    public VehicleType getType() {
        return type;
    }

   
    public int getCapacity() {
        return capacity;
    }

  
    public VehicleStatus getStatus() {
        return status;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

   
    public void setCurrentLocation(Location location) {
        this.currentLocation = location;
    }

    public void notifyArrivedAtPickup() {
        if (this.status == VehicleStatus.EN_ROUTE_TO_PICKUP) {
            this.status = VehicleStatus.AT_PICKUP_LOCATION;
            System.out.println("Driver: Vehicle " + vehicleId + " (" + type + ") arrived at pickup location.");
        }
    }

   
    public void notifyDroppedOffPassengers() {
        if (this.status == VehicleStatus.TRANSPORTING_PASSENGERS || this.status == VehicleStatus.AT_PICKUP_LOCATION) {
            this.status = VehicleStatus.AVAILABLE; // Vehicle becomes available again
            System.out.println("Driver: Vehicle " + vehicleId + " (" + type + ") dropped off passengers and is now AVAILABLE.");
        }
    }

    @Override
    public String toString() {
        return "Vehicle-" + vehicleId + " (Type: " + type + ", Capacity: " + capacity + ", Status: " + status + ")";
    }
}
    

