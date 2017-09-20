package Agile.Trailblazers.Repository;


import Agile.Trailblazers.Entity.Coordinates;
import Agile.Trailblazers.Entity.WeatherDetails;

import java.util.List;

public interface WeatherRepository {
    WeatherDetails post(WeatherDetails weather);
    WeatherDetails findbyCityCoordinates(float latitude, float longitude);
}
