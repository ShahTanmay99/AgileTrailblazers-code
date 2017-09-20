package Agile.Trailblazers.Repository;

import Agile.Trailblazers.Entity.Coordinates;
import Agile.Trailblazers.Entity.WeatherDetails;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class WeatherRepositoryImpl implements WeatherRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public WeatherDetails post(WeatherDetails weather) {
        entityManager.persist(weather.getCoordinates());
        entityManager.persist(weather);
        return weather;
    }

    public WeatherDetails findbyCityCoordinates(float latitude, float longitude) {
        TypedQuery<WeatherDetails> query = entityManager.createNamedQuery("WeatherDetails.findbyCityCoordinates",WeatherDetails.class);
        query.setParameter("paramLatitude", latitude);
        query.setParameter("paramLongitude", longitude);
        List<WeatherDetails> resultList = query.getResultList();
        if (resultList != null) {
            System.out.print(resultList.get(0).toString());
            return resultList.get(0);
        } else {
            return null;
        }
    }
}
