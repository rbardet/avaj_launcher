package aircraft;

import simulation.Coordinates;

public class AircraftFactory {

	private long id = 0;
	private static AircraftFactory instance = null;
	private final static String[] validType = {"Baloon", "Helicopter", "JetPlane"};

	private AircraftFactory() {
	}

	public static synchronized AircraftFactory getInstance() {
		if (instance == null) {
			instance = new AircraftFactory();
		}
		return instance;
	}

	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
		this.id++;
		return switch (p_type) {
			case "JetPlane" ->
				new JetPlane(this.id, p_name, p_coordinates, "JetPlane");
			case "Helicopter" ->
				new Helicopter(this.id, p_name, p_coordinates, "Helicopter");
			case "Baloon" ->
				new Baloon(this.id, p_name, p_coordinates, "Baloon");
			default ->
				null;
		};
	}

	public static boolean isValidType(String type) {
		for (String name : validType) {
			if (name.equals(type)) {
				return true;
			}
		}
		return false;
	}
}
