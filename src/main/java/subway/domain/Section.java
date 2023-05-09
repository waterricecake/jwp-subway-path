package subway.domain;

public class Section {
    private final Long id;
    private final String departure;
    private final String arrival;
    private final int distance;

    public Section(Long id, String departure, String arrival, int distance) {
        this.id = id;
        this.departure = departure;
        this.arrival = arrival;
        this.distance = distance;
    }

    public Long getId() {
        return id;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public int getDistance() {
        return distance;
    }
}
