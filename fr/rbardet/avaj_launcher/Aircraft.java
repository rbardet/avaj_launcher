public abstract class Aircraft extends Flyable {
	protected long id;
	protected String name;
	protected Coordinates coordinates;

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinate) {
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinate;
	}

	public abstract void updateConditions();
}

// + for public 
// - for private
// # for protected
// ~ for package or default visibility (visible to classes in the same package)

