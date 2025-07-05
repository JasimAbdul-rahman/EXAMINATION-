import java.util.Random;

public class Pm25TrackerWhileLoop {

    public static void main(String[] args) {
        System.out.println("--- NEMA AirQO PM2.5 Tracking (using while loop) ---");

        Random random = new Random();
        int totalDays = 30;

        int day = 1;

        while (day <= totalDays) {

            double pm25Level = 0.0 + (50.0 - 0.0) * random.nextDouble();

            System.out.printf("Day %d: PM2.5 Level = %.2f µg/m³%n", day, pm25Level);

            
            day++; 

            // Simulate some delay for realism (optional)
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("30-day PM2.5 tracking complete (while loop) ");
    }
}