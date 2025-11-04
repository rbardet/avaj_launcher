public class AircraftFactory {
	private long id = 0;
	private static AircraftFactory instance = null;

	private AircraftFactory() {}

	public static synchronized AircraftFactory getInstance() {
		if (instance == null) {
			instance = new AircraftFactory();
		}
		return instance;
	}

	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
		this.id++;
		switch (p_type) {
			case "JetPlane":
				return new JetPlane(this.id, p_name, p_coordinates);
			case "Helicopter":
				return new Helicopter(this.id, p_name, p_coordinates);
			case "Baloon":
				return new Baloon(this.id, p_name, p_coordinates);
			default:
				return null;
		}
	}
}