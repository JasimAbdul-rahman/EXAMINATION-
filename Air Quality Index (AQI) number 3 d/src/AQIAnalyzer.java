import java.util.ArrayList;
import java.util.Collections; // For sorting the list
import java.util.List;
import java.util.Random;

public class AQIAnalyzer {

    public static void main(String[] args) {
        System.out.println("--- AirQO AQI Monitoring Dashboard ---");
        System.out.println("Analyzing PM2.5 Levels for Kampala City (30 Days Simulation)\n");
        List<Integer> aqiReadings = new ArrayList<>();
        Random random = new Random();
        int numberOfReadings = 30; 

        System.out.println("Generated Daily AQI Readings:");
        for (int i = 0; i < numberOfReadings; i++) {
            int aqi = random.nextInt(300) + 1;
            aqiReadings.add(aqi);
            System.out.println("Day " + (i + 1) + ": AQI = " + aqi);
        }

        Collections.sort(aqiReadings);

        System.out.println("\nSorted AQI Readings: " + aqiReadings);

        double medianAQI;
        int middleIndex = numberOfReadings / 2;
        if (numberOfReadings % 2 == 0) {
            int value1 = aqiReadings.get(middleIndex - 1); 
            int value2 = aqiReadings.get(middleIndex);    
            medianAQI = (double) (value1 + value2) / 2.0;
        } else {
            medianAQI = aqiReadings.get(middleIndex);
        }
        String formattedMedianAQI = String.format("%.2f", medianAQI); 
        System.out.println("\nComputed Median AQI Value: " + formattedMedianAQI);
        int hazardousDaysCount = 0;
        int hazardousThreshold = 200;

        System.out.println("\nHazardous Days (AQI > " + hazardousThreshold + "):");
        for (int i = 0; i < numberOfReadings; i++) {
            int aqi = aqiReadings.get(i);
            if (aqi > hazardousThreshold) {
                hazardousDaysCount++;
                System.out.println("  - Day (original order unknown after sort): AQI = " + aqi);
            }
        }

        System.out.println("\nTotal number of Hazardous Days (AQI > " + hazardousThreshold + "): " + hazardousDaysCount);
        System.out.println("\nAnalysis Complete ");
    }
}
