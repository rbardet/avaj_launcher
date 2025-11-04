import java.util.List;

public class Tower {
	private List<Flyable> observers;

	public void register(Flyable p_flyable) {
		System.out.println("Tower says: registered to weather tower.");
		this.observers.add(p_flyable);
	}

	public void unregister(Flyable p_flyable) {
		System.out.println("Tower says: unregistered from weather tower.");
		this.observers.remove(p_flyable);
	}
}