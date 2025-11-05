package aircraft;

import simulation.Coordinates;
import simulation.SimulationIO;
import weather.WeatherTower;

public class Baloon extends Aircraft {

	public Baloon(long p_id, String p_name, Coordinates p_coordinate, String p_type) {
		super(p_id, p_name, p_type, p_coordinate);
	}

	@Override
	public void updateConditions() {
		final String weather = WeatherTower.getWeather(this.coordinates);
		switch (weather) {
			case "SUN" -> {
				SimulationIO.writer.println(this.getIdentity() + ": Sun! Finally!");
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
				this.coordinates.setHeight(this.coordinates.getHeight() + 4);
				break;
			}
			case "RAIN" -> {
				SimulationIO.writer.println(this.getIdentity() + ": Damn you rain! You messed up my baloon.");
				this.coordinates.setHeight(this.coordinates.getHeight() - 5);
				break;
			}
			case "FOG" -> {
				SimulationIO.writer.println(this.getIdentity() + ": It's foggy. I can't see anything");
				this.coordinates.setHeight(this.coordinates.getHeight() - 3);
				break;
			}
			case "SNOW" -> {
				SimulationIO.writer.println(this.getIdentity() + ": It's snowing. We're gonna crash.");
				this.coordinates.setHeight(this.coordinates.getHeight() - 15);
				break;
			}
		}

		if (this.IsOnTheGround()) {
			SimulationIO.writer.println(this.getIdentity() + ": landing.");
			Flyable.weatherTower.unregister(this);
		}
	}
}
