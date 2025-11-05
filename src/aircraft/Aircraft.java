package aircraft;

import simulation.Coordinates;

public abstract class Aircraft extends Flyable {

	protected long id;
	protected String name;
	protected String type;
	protected Coordinates coordinates;

	protected Aircraft(long p_id, String p_name, String p_type, Coordinates p_coordinate) {
		this.id = p_id;
		this.name = p_name;
		this.type = p_type;
		this.coordinates = p_coordinate;
	}

	public long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getType() {
		return this.type;
	}

	public Coordinates getCoordinates() {
		return this.coordinates;
	}

	public String getIdentity() {
		String Identity = this.getType() + "#" + this.getName() + "(" + this.getId() + ")";
		return Identity;
	}

	public boolean IsOnTheGround() {
		if (this.coordinates.getHeight() <= 0) {
			return (true);
		} else {
			return (false);
		}
	}
}
