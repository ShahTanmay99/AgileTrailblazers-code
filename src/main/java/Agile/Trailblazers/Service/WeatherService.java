package Agile.Trailblazers.Service;



import Agile.Trailblazers.Entity.Coordinates;
import Agile.Trailblazers.Entity.WeatherDetails;

import java.util.List;

public interface WeatherService {
    WeatherDetails post(WeatherDetails weather);
    WeatherDetails findbyCityCoordinates(float latitude, float longitude);
    WeatherDetails getWeather(WeatherDetails city1, WeatherDetails city2);
}
