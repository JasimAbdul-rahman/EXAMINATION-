import java.util.Random;

public class Company {
    private final Vehicle singleVehicle; // Now managing a single Vehicle instance
    private final Random random = new Random();
    private int lostFaresCount = 0;

    public Company() {
        this.singleVehicle = new Vehicle(Vehicle.VehicleType.SHUTTLE, 7);
        System.out.println("Company: Initialized with a single vehicle: " + singleVehicle.getVehicleId() +
                           " (Type: " + singleVehicle.getType() + ", Capacity: " + singleVehicle.getCapacity() + ")");
    }

    public Vehicle getSingleVehicle() {
        return singleVehicle;
    }

    public boolean scheduleVehicle(Passenger passenger, Location pickupLocation, Location destinationLocation, int numSeatsRequired) {
        if (singleVehicle.getStatus() == Vehicle.VehicleStatus.AVAILABLE && singleVehicle.getCapacity() >= numSeatsRequired) {
            singleVehicle.setStatus(Vehicle.VehicleStatus.EN_ROUTE_TO_PICKUP);
            System.out.println("Company: Successfully scheduled " + singleVehicle.getVehicleId() + " (" + singleVehicle.getType() + ")" +
                               " for " + passenger + " from " + pickupLocation + " to " + destinationLocation +
                               " (Seats: " + numSeatsRequired + "). Vehicle status: " + singleVehicle.getStatus());

            new Thread(() -> {
                try {
                    Thread.sleep(2000);
                    singleVehicle.notifyArrivedAtPickup();
                    Thread.sleep(3000);
                    singleVehicle.setStatus(Vehicle.VehicleStatus.TRANSPORTING_PASSENGERS);
                    singleVehicle.notifyDroppedOffPassengers();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Simulation interrupted for vehicle " + singleVehicle.getVehicleId());
                }
            }).start();

            return true;
        } else {
            System.out.println("Company: No vehicle available (single vehicle is busy or too small) for " + passenger +
                               " from " + pickupLocation + " to " + destinationLocation + ". Request lost.");
            lostFaresCount++;
            return false;
        }
    }

    public int getLostFaresCount() {
        return lostFaresCount;
    }

    public void monitorVehicleTime() {
        System.out.println("\n--- Vehicle Time Monitoring ---");
        System.out.println(singleVehicle.getVehicleId() + " (" + singleVehicle.getType() + "): Current Status - " + singleVehicle.getStatus());
        System.out.println("Total Lost Fares: " + lostFaresCount);
    }
}