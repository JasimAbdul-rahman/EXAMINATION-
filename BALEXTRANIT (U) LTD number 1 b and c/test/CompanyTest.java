import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CompanyTest {

    private Company company;
    private Vehicle testVehicle; 

    @BeforeEach
   public void setUp() {
        company = new Company();
        
        testVehicle = company.getSingleVehicle();
    }

   
    @Test
    public void testScheduleVehicleSuccess() {
       
        Passenger passenger = new Passenger();
        Location pickup = new Location(10, 20);
        Location destination = new Location(50, 60);
        int numSeatsRequired = 4;

     
        boolean scheduled = company.scheduleVehicle(passenger, pickup, destination, numSeatsRequired);

        assertTrue(scheduled, "Vehicle should be scheduled successfully.");
        assertEquals(0, company.getLostFaresCount(), "Lost fares count should remain 0 on success.");
        assertEquals(Vehicle.VehicleStatus.EN_ROUTE_TO_PICKUP, testVehicle.getStatus(),
                     "Vehicle status should change to EN_ROUTE_TO_PICKUP immediately.");
    }

    @Test
    void testScheduleVehicleFailure_VehicleBusy() {
  
        testVehicle.setStatus(Vehicle.VehicleStatus.EN_ROUTE_TO_PICKUP); // Manually set to a busy status

        Passenger passenger = new Passenger();
        Location pickup = new Location(10, 20);
        Location destination = new Location(50, 60);
        int numSeatsRequired = 4;

        // Act
        boolean scheduled = company.scheduleVehicle(passenger, pickup, destination, numSeatsRequired);

        // Assert
        assertFalse(scheduled, "Vehicle should NOT be scheduled when busy.");
        assertEquals(1, company.getLostFaresCount(), "Lost fares count should increment by 1.");
        // Verify vehicle status remains unchanged as it was already busy
        assertEquals(Vehicle.VehicleStatus.EN_ROUTE_TO_PICKUP, testVehicle.getStatus(),
                     "Vehicle status should remain busy.");
    }

    @Test
    void testScheduleVehicleFailure_VehicleTooSmall() {
  
        testVehicle.setStatus(Vehicle.VehicleStatus.AVAILABLE); // Ensure it's available
   
        Passenger passenger = new Passenger();
        Location pickup = new Location(10, 20);
        Location destination = new Location(50, 60);
        int numSeatsRequired = 8; 
        boolean scheduled = company.scheduleVehicle(passenger, pickup, destination, numSeatsRequired);

        assertFalse(scheduled, "Vehicle should NOT be scheduled when capacity is insufficient.");
        assertEquals(1, company.getLostFaresCount(), "Lost fares count should increment by 1.");
        assertEquals(Vehicle.VehicleStatus.AVAILABLE, testVehicle.getStatus(),
                     "Vehicle status should remain AVAILABLE.");
    }
}