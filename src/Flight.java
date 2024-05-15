public class Flight {
    private String origin;
    private String origin_name;
    private String destination;
    private String destination_name;
    private String departure_date;
    private String departure_time;
    private String arrival_date;
    private String arrival_time;
    private String carrier;
    private int stops;
    private int price;

    // Constructor
    public Flight(String origin, String origin_name, String destination, String destination_name,
                  String departure_date, String departure_time, String arrival_date, String arrival_time,
                  String carrier, int stops, int price) {
        this.origin = origin;
        this.origin_name = origin_name;
        this.destination = destination;
        this.destination_name = destination_name;
        this.departure_date = departure_date;
        this.departure_time = departure_time;
        this.arrival_date = arrival_date;
        this.arrival_time = arrival_time;
        this.carrier = carrier;
        this.stops = stops;
        this.price = price;
    }

    // Getters and Setters (previously provided)

    // Getters
    public String getOrigin() {
        return origin;
    }

    public String getOrigin_name() {
        return origin_name;
    }

    public String getDestination() {
        return destination;
    }

    public String getDestination_name() {
        return destination_name;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public String getArrival_date() {
        return arrival_date;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public String getCarrier() {
        return carrier;
    }

    public int getStops() {
        return stops;
    }

    public int getPrice() {
        return price;
    }

    // Setters (previously provided)

    // Setters
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setOrigin_name(String origin_name) {
        this.origin_name = origin_name;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDestination_name(String destination_name) {
        this.destination_name = destination_name;
    }

    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public void setArrival_date(String arrival_date) {
        this.arrival_date = arrival_date;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public void setStops(int stops) {
        this.stops = stops;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
