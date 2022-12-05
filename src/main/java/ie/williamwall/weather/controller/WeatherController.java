package ie.williamwall.weather.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ie.williamwall.weather.exception.WeatherResourceNotFoundException;
import ie.williamwall.weather.model.Weather;
import ie.williamwall.weather.service.WeatherService;

@RestController
@RequestMapping("/api")
public class WeatherController {

	@Autowired
	WeatherService weatherService;

	@RequestMapping(value = "/weather", method = RequestMethod.POST)
	public Weather createWeatherRecord(@RequestBody Weather weather) {
		return weatherService.createWeatherRecord(weather);
	}

	@RequestMapping(value = "/weather", method = RequestMethod.GET)
	public List<Weather> retrieveWeatherRecords() {
		return weatherService.retrieveWeatherRecords();
	}

	@RequestMapping(value = "/weather/{station}", method = RequestMethod.GET)
	public List<Weather> retrieveWeatherRecordsStation(@PathVariable(value = "station") String station) {
		return weatherService.retrieveWeatherRecordsStation(station);
	}

	@RequestMapping(value = "/weather/{station}/{metric}/{from}/{to}", method = RequestMethod.GET)
	public ResponseEntity<Object> retrieveWeatherRecordsStationAndMetric(
			@PathVariable(value = "station") String station, @PathVariable(value = "metric") String metric,
			@PathVariable(value = "from") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate from,
			@PathVariable(value = "to") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate to) {
		Map<String, Object> response = weatherService.retrieveWeatherRecordsStationMetric(station, metric, from, to);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/weather/{station}/{metric}", method = RequestMethod.GET)
	public ResponseEntity<Object> retrieveWeatherRecordsStationAndMetric(
			@PathVariable(value = "station") String station, @PathVariable(value = "metric") String metric) {
		Map<String, Object> response = weatherService.retrieveWeatherRecordsStationMetric(station, metric);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/weather/{id}", method = RequestMethod.PUT)
	public Weather updateWeatherRecord(@PathVariable(value = "id") Long id, @RequestBody Weather weather)
			throws WeatherResourceNotFoundException {
		return weatherService.updateWeatherRecord(id, weather);
	}

	@RequestMapping(value = "/weather/{id}", method = RequestMethod.DELETE)
	public void deleteWeatherRecord(@PathVariable(value = "id") Long id) {
		weatherService.deleteWeatherRecord(id);
	}
}
