package aircraft;

import simulation.Main;
import simulation.SimulationIO;
import weather.WeatherTower;

public class JetPlane extends Aircraft {

	public JetPlane(long p_id, String p_name, Coordinates p_coordinate, String p_type) {
		super(p_id, p_name, p_type, p_coordinate);
	}

	@Override
	public void updateConditions() {
		final String weather = WeatherTower.getWeather(this.coordinates);
		switch (weather) {
			case "SUN" -> {
				SimulationIO.writer.println(this.getIdentity() + ": This sun is cooking me alive!");
				this.coordinates.setLatitute(this.coordinates.getLatitute() + 10);
				this.coordinates.setHeight(this.coordinates.getHeight() + 2);
				break;
			}
			case "RAIN" -> {
				SimulationIO.writer.println(this.getIdentity() + ": It's raining. Better watch out for lightings.");
				this.coordinates.setLatitute(this.coordinates.getLatitute() + 5);
				break;
			}
			case "FOG" -> {
				SimulationIO.writer.println(this.getIdentity() + ": Fog, get out of my airspace!");
				this.coordinates.setLatitute(this.coordinates.getLatitute() + 1);
				break;
			}
			case "SNOW" -> {
				SimulationIO.writer.println(this.getIdentity() + ": OMG! Winter is coming!");
				this.coordinates.setHeight(this.coordinates.getHeight() - 7);
				break;
			}
		}

		if (this.IsOnTheGround()) {
			SimulationIO.writer.println(this.getIdentity() + ": landing.");
			Main._tower.unregister(this);
		}
	}
}
