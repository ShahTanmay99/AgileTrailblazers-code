package Agile.Trailblazers.Service;

import Agile.Trailblazers.Entity.Coordinates;
import Agile.Trailblazers.Entity.WeatherDetails;
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
        return repository.findbyCityCoordinates(latitude, longitude);
    }
}

