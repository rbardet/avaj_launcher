package aircraft;

import weather.WeatherTower;

public abstract class Flyable {
	protected static WeatherTower weatherTower = new WeatherTower();

	public abstract void updateConditions();

	public static void registerTower(WeatherTower p_Tower) {
		weatherTower = p_Tower;
	}

	public static void addAircraft(Flyable p_flyable) {
		weatherTower.register(p_flyable);
	}

	public static void removeAircraft(Flyable p_flyable) {
		weatherTower.unregister(p_flyable);
	}

	public static void changeAircraftWeather() {
		weatherTower.changeWeather();
	}
}
