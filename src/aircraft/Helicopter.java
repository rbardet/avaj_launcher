package aircraft;

import simulation.Coordinates;
import simulation.SimulationIO;
import weather.WeatherTower;

public class Helicopter extends Aircraft {

	public Helicopter(long p_id, String p_name, Coordinates p_coordinate, String p_type) {
		super(p_id, p_name, p_type, p_coordinate);
	}

	@Override
	public void updateConditions() {
		final String weather = WeatherTower.getWeather(this.coordinates);
		switch (weather) {
			case "SUN" -> {
				SimulationIO.writer.println(this.getIdentity() + ": This is hot.");
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
				this.coordinates.setHeight(this.coordinates.getHeight() + 2);
				break;
			}
			case "RAIN" -> {
				SimulationIO.writer.println(this.getIdentity() + ": Damn rain! You're messing with my rotors!");
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
				break;
			}
			case "FOG" -> {
				SimulationIO.writer.println(this.getIdentity() + ": Cut it out fog! I can't navigate like this!");
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
				break;
			}
			case "SNOW" -> {
				SimulationIO.writer.println(this.getIdentity() + ": My rotor is going to freeze!");
				this.coordinates.setHeight(this.coordinates.getHeight() - 12);
				break;
			}
		}

		if (this.IsOnTheGround()) {
			SimulationIO.writer.println(this.getIdentity() + ": landing.");
			Flyable.weatherTower.unregister(this);
		}
	}
}
