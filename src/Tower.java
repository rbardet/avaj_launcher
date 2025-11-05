
import java.util.ArrayList;
import java.util.List;

public class Tower {

	private final List<Flyable> observers;

	public Tower() {
		this.observers = new ArrayList<>();
	}

	public void register(Flyable p_flyable) {
		SimulationIO.writer.println("Tower says: " + ((Aircraft) p_flyable).getIdentity() + " registered to weather tower.");
		this.observers.add(p_flyable);
	}

	public void unregister(Flyable p_flyable) {
		SimulationIO.writer.println("Tower says: " + ((Aircraft) p_flyable).getIdentity() + " unregistered to weather tower.");
		this.observers.remove(p_flyable);
	}

	protected void conditionChanged() {
		for (int i = 0; i < this.observers.size(); i++) {
			this.observers.get(i).updateConditions();
		}
	}
}
