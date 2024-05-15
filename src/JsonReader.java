import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JsonReader {
    public static Flight[] readFlights(String filename) throws IOException {
        Gson gson = new Gson();
        try (Reader reader = new FileReader(filename)) {
            // Read the entire JSON object
            TicketWrapper ticketWrapper = gson.fromJson(reader, TicketWrapper.class);
            // Extract flights from the nested "tickets" array
            return ticketWrapper.tickets;
        }
    }

    // Define a wrapper class to match the structure of the JSON file
    private static class TicketWrapper {
        Flight[] tickets;
    }
}
