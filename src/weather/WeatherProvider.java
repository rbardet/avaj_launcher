package weather;

import simulation.Coordinates;

public class WeatherProvider {

	private final static String weather[] = {"RAIN", "FOG", "SUN", "SNOW"};
	private static WeatherProvider instance = null;

	private WeatherProvider() {
	}

	public static synchronized WeatherProvider getInstance() {
		if (instance == null) {
			instance = new WeatherProvider();
		}
		return instance;
	}

	public String getCurrentWeather(Coordinates p_coordinates) {
		int sum = (p_coordinates.getHeight() + p_coordinates.getLongitude() + p_coordinates.getLatitute()) % 4;

		return weather[sum];
	}

}
