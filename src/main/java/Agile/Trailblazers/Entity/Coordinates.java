package Agile.Trailblazers.Entity;

import javax.persistence.Id;
import java.util.UUID;

public class Coordinates {
    @Id
    private String id;
    private float latitude;
    private float longitude;

    public Coordinates(){
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }
}
