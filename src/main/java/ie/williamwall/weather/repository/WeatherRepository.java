package ie.williamwall.weather.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ie.williamwall.weather.model.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {
	List<Weather> findByStation(String station);

	@Query("SELECT w FROM Weather w WHERE w.station = ?1 AND w.date >= ?2 AND w.date <= ?3")
	List<Weather> getMetricData(String station, LocalDate from, LocalDate to);
	
	@Query("SELECT w FROM Weather w WHERE w.station = ?1")
	List<Weather> getMetricData(String station);
}