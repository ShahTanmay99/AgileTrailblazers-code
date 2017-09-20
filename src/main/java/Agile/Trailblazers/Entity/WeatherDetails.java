package Agile.Trailblazers.Entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name = "WeatherDetails.findbyCityCoordinates",
                query = "SELECT w FROM WeatherDetails w WHERE w.coordinates.latitude=:latitude and w.coordinates.longitude=:longitude")
})
public class WeatherDetails {

    @Id
    private String id;
    private Timestamp timestamp;
    private String name;
    private int temperature;
    private String tempretureDifference;

    @OneToOne
    private Coordinates coordinates;

    public WeatherDetails() {
        this.id = UUID.randomUUID().toString();
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getTempretureDifference() {
        return tempretureDifference;
    }

    public void setTempretureDifference(String tempretureDifference) {
        this.tempretureDifference = tempretureDifference;
    }
}
