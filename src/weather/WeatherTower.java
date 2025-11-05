package weather;

import simulation.Coordinates;

public class WeatherTower extends Tower {

	private final static WeatherProvider weather = WeatherProvider.getInstance();

	public static String getWeather(Coordinates p_Coordinates) {
		return weather.getCurrentWeather(p_Coordinates);
	}

	public void changeWeather() {
		this.conditionChanged();
	}
}
