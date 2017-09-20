package Agile.Trailblazers.Service;

import Agile.Trailblazers.Entity.Coordinates;
import Agile.Trailblazers.Entity.WeatherDetails;
import Agile.Trailblazers.Exception.BadRequestException;
import Agile.Trailblazers.Exception.NotFoundException;
import Agile.Trailblazers.Repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    WeatherRepository repository;

    @Transactional
    public WeatherDetails post(WeatherDetails weather) {
        return repository.post(weather);
    }
    public WeatherDetails findbyCityCoordinates(float latitude, float longitude) {
        WeatherDetails city = repository.findbyCityCoordinates(latitude, longitude);
        if(city == null)
            throw new BadRequestException("Latitude or Longitude is not valid for city");
        return city;
    }
    public WeatherDetails getWeather(WeatherDetails city1, WeatherDetails city2){
        WeatherDetails city = repository.getWeather(city1, city2);
        if(city == null)
            throw new NotFoundException("Cannot find the City");
        return city;
    }
}

