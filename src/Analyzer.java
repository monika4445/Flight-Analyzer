import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Analyzer {
    public static void main(String[] args) {
        try {
            Flight[] flights = JsonReader.readFlights("/home/monika/Desktop/Projects/FlightAnalyzer/tickets.json");
            calculateMinFlightTime(flights);
            calculatePriceDifference(flights);
        } catch (IOException e) {
            System.err.println("Error reading JSON file: " + e.getMessage());
        }
    }

    private static void calculateMinFlightTime(Flight[] flights) {
        // Map to store minimum flight time for each carrier
        Map<String, Integer> minFlightTimeMap = new HashMap<>();

        // Initialize minimum flight time for each carrier as Integer.MAX_VALUE
        for (Flight flight : flights) {
            minFlightTimeMap.put(flight.getCarrier(), Integer.MAX_VALUE);
        }

        // Update minimum flight time for each carrier
        for (Flight flight : flights) {
            if (flight.getOrigin().equals("VVO") && flight.getDestination().equals("TLV")) {
                int currentMin = minFlightTimeMap.get(flight.getCarrier());
                int flightTime = calculateFlightTime(flight.getDeparture_time(), flight.getArrival_time());
                minFlightTimeMap.put(flight.getCarrier(), Math.min(currentMin, flightTime));
            }
        }

        // Print minimum flight time for each carrier
        System.out.println("Minimum flight time between Vladivostok and Tel Aviv for each carrier:");
        for (Map.Entry<String, Integer> entry : minFlightTimeMap.entrySet()) {
            int flightTimeInMinutes = entry.getValue();
            int hours = flightTimeInMinutes / 60;
            int remainingMinutes = flightTimeInMinutes % 60;
            System.out.println(entry.getValue() + " minutes (" + hours + " hours " + remainingMinutes + " minutes)");
        }
    }


    private static void calculatePriceDifference(Flight[] flights) {
        // Calculate average price and median price for flights between Vladivostok and Tel Aviv
        int totalPrice = 0;
        int[] prices = new int[flights.length];
        for (int i = 0; i < flights.length; i++) {
            prices[i] = flights[i].getPrice();
            totalPrice += prices[i];
        }
        double averagePrice = totalPrice / (double) flights.length;
        Arrays.sort(prices);
        double medianPrice;
        if (flights.length % 2 == 0) {
            medianPrice = (prices[flights.length / 2 - 1] + prices[flights.length / 2]) / 2.0;
        } else {
            medianPrice = prices[flights.length / 2];
        }

        // Calculate and print price difference
        double priceDifference = averagePrice - medianPrice;
        System.out.println("Difference between average price and median price for flights between Vladivostok and Tel Aviv: " + priceDifference);
    }

    private static int calculateFlightTime(String departureTime, String arrivalTime) {
        // Calculate flight time in minutes
        int departureHour = Integer.parseInt(departureTime.split(":")[0]);
        int departureMinute = Integer.parseInt(departureTime.split(":")[1]);
        int arrivalHour = Integer.parseInt(arrivalTime.split(":")[0]);
        int arrivalMinute = Integer.parseInt(arrivalTime.split(":")[1]);

        int departureTotalMinutes = departureHour * 60 + departureMinute;
        int arrivalTotalMinutes = arrivalHour * 60 + arrivalMinute;

        return arrivalTotalMinutes - departureTotalMinutes;
    }
}
