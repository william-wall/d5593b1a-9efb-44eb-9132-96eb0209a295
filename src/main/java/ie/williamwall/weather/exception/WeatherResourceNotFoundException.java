package ie.williamwall.weather.exception;

public class WeatherResourceNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public WeatherResourceNotFoundException(String error) {
		super(error);
	}
	
	public WeatherResourceNotFoundException() {
		super();
	}
}