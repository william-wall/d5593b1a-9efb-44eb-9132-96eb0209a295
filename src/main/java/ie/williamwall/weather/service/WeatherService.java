package ie.williamwall.weather.service;

import java.util.List;
import java.util.Map;

import static java.util.Objects.nonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.williamwall.weather.enumeration.MetricMeasurement;
import ie.williamwall.weather.enumeration.MetricType;
import ie.williamwall.weather.exception.WeatherResourceNotFoundException;
import ie.williamwall.weather.model.Metric;
import ie.williamwall.weather.model.Weather;
import ie.williamwall.weather.repository.WeatherRepository;

@Service
public class WeatherService {

	@Autowired
	WeatherRepository weatherRepository;

	public Weather createWeatherRecord(Weather weather) {
		return weatherRepository.save(weather);
	}

	public List<Weather> retrieveWeatherRecords() {
		return weatherRepository.findAll();
	}

	public List<Weather> retrieveWeatherRecordsStation(String station) {
		return weatherRepository.findByStation(station);
	}

	public Map<String, Object> retrieveWeatherRecordsStationMetric(String station, String metric, LocalDate from,
			LocalDate to) {
		List<Weather> records = weatherRepository.getMetricData(station, from, to);
		Metric metricRecord = buildMetricRecord(metric, records);
		return createResponse(metric, metricRecord);
	}

	public Map<String, Object> retrieveWeatherRecordsStationMetric(String station, String metric) {
		List<Weather> records = weatherRepository.getMetricData(station);
		Metric metricRecord = buildMetricRecord(metric, records);
		return createResponse(metric, metricRecord);
	}

	public Weather updateWeatherRecord(Long id, Weather weather) throws WeatherResourceNotFoundException {
		Weather weatherRecord = weatherRepository.findById(id)
				.orElseThrow(() -> new WeatherResourceNotFoundException("No record matches id: " + id));
		weatherRecord.setAirPressure(weather.getAirPressure());
		weatherRecord.setDate(weather.getDate());
		weatherRecord.setDewPoint(weather.getDewPoint());
		weatherRecord.setHumidity(weather.getHumidity());
		weatherRecord.setStation(weather.getStation());
		weatherRecord.setTemperature(weather.getTemperature());
		weatherRecord.setWindSpeed(weather.getWindSpeed());
		return weatherRepository.save(weatherRecord);
	}

	public void deleteWeatherRecord(Long id) {
		weatherRepository.deleteById(id);
	}

	private Metric buildMetricRecord(String metric, List<Weather> records) {
		List<Double> metricValues = new ArrayList<>();
		for (Weather weather : records) {
			if (MetricType.TEMPERATURE.toString().equals(metric)) {
				if (nonNull(weather.getTemperature())) {
					metricValues.add(weather.getTemperature());
				}
			}
			if (MetricType.HUMIDITY.toString().equals(metric)) {
				if (nonNull(weather.getHumidity())) {
					metricValues.add(weather.getHumidity());
				}
			}
			if (MetricType.WIND_SPEED.toString().equals(metric)) {
				if (nonNull(weather.getWindSpeed())) {
					metricValues.add(weather.getWindSpeed());
				}
			}
			if (MetricType.AIR_PRESSURE.toString().equals(metric)) {
				if (nonNull(weather.getAirPressure())) {
					metricValues.add(weather.getAirPressure());
				}
			}
			if (MetricType.DEW_POINT.toString().equals(metric)) {
				if (nonNull(weather.getDewPoint())) {
					metricValues.add(weather.getDewPoint());
				}
			}
		}
		return new Metric(metric, metricValues);
	}

	private Map<String, Object> createResponse(String metric, Metric metricRecord) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put(MetricMeasurement.TYPE.toString(), metric);
		response.put(MetricMeasurement.MINIMUM.toString(), metricRecord.getMinimum());
		response.put(MetricMeasurement.MAXIMUM.toString(), metricRecord.getMaximum());
		response.put(MetricMeasurement.AVERAGE.toString(), metricRecord.getAverage());
		response.put(MetricMeasurement.TOTAL.toString(), metricRecord.getTotal());
		return response;
	}
}
