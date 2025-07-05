import java.util.Random;
public class PassengerSource { // This class is public because it contains the main method
    private final Company company;
    private final Random random;

    public PassengerSource(Company company) {
        this.company = company;
        this.random = new Random();
    }

    public boolean requestPickup() {
        Passenger passenger = new Passenger();
        Location pickupLocation = new Location(random.nextInt(101), random.nextInt(101));
        Location destinationLocation = new Location(random.nextInt(101), random.nextInt(101));
        int numSeatsRequired = random.nextInt(10) + 1; // Generates 1 to 10 seats

        System.out.println("\nPassengerSource: Requesting pickup for " + passenger +
                           " from " + pickupLocation + " to " + destinationLocation +
                           " with " + numSeatsRequired + " seats.");

        return company.scheduleVehicle(passenger, pickupLocation, destinationLocation, numSeatsRequired);
    }

    private static void pause(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread was interrupted during pause.");
        }
    }

    public static void main(String[] args) {
        Company balextranit = new Company(); 
        PassengerSource individualSource = new PassengerSource(balextranit);

        System.out.println("\n--- Simulating Multiple Pickup Requests ---");

        for (int i = 0; i < 10; i++) {
            individualSource.requestPickup();
            pause(1000); 
        }

        pause(7000);

  
    }
}