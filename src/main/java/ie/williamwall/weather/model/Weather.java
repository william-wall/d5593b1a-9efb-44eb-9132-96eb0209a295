package ie.williamwall.weather.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "weather")
public class Weather {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "station")
	private String station;

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "temperature")
	private Double temperature;

	@Column(name = "humidity")
	private Double humidity;

	@Column(name = "wind_speed")
	private Double windSpeed;

	@Column(name = "air_pressure")
	private Double airPressure;

	@Column(name = "dew_point")
	private Double dewPoint;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Double getHumidity() {
		return humidity;
	}

	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}

	public Double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(Double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public Double getAirPressure() {
		return airPressure;
	}

	public void setAirPressure(Double airPressure) {
		this.airPressure = airPressure;
	}

	public Double getDewPoint() {
		return dewPoint;
	}

	public void setDewPoint(Double dewPoint) {
		this.dewPoint = dewPoint;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
