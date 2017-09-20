package Agile.Trailblazers.Controller;

import Agile.Trailblazers.Entity.WeatherDetails;
import Agile.Trailblazers.Service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/weather")
@Api(tags = "weather")
public class WeatherController {

    @Autowired
    WeatherService service;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Post Weather Details", notes = "Posts new Weather Update")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error"), })
    public WeatherDetails create(@RequestBody WeatherDetails weather) {
        return service.post(weather);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/lat1={latitude1}&lon1={longitude1}&lat2={latitude2}&lon2={longitude2}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Compares Weather of given two cities", notes = "Returns respective properties of each City")
    public WeatherDetails getDetails(@PathVariable("latitude1") float latitude1, @PathVariable("longitude1") float longitude1,
                            @PathVariable("latitude2") float latitude2, @PathVariable("longitude2") float longitude2){
            WeatherDetails city_1= service.findbyCityCoordinates(latitude1, longitude1);
            WeatherDetails city_2= service.findbyCityCoordinates(latitude2, longitude2);
            return service.getWeather(city_1,city_2);
    }
}
