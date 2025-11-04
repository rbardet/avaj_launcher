
import java.util.ArrayList;
import java.util.List;

public class Tower {

	private List<Flyable> observers;

	public Tower() {
		this.observers = new ArrayList<Flyable>();
	}

	public void register(Flyable p_flyable) {
		String Identity = ((Aircraft) p_flyable).getType() + "#" + ((Aircraft) p_flyable).getName() + "(" + ((Aircraft) p_flyable).getId() + ")";
		SimulationIO.writer.println("Tower says: " + Identity + " registered to weather tower.");
		this.observers.add(p_flyable);
	}

	public void unregister(Flyable p_flyable) {
		String Identity = ((Aircraft) p_flyable).getType() + "#" + ((Aircraft) p_flyable).getName() + "(" + ((Aircraft) p_flyable).getId() + ")";
		SimulationIO.writer.println("Tower says: " + Identity + " unregistered to weather tower.");
		this.observers.remove(p_flyable);
	}
}
