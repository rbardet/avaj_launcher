
import java.util.List;

public class Main {

	private static int TimeToRun;
	private final static int TYPE = 0;
	private final static int NAME = 1;
	private final static int LONGITUDE = 2;
	private final static int LATITUDE = 3;
	private final static int HEIGHT = 4;
	public final static String ERROR = "Invalid scenario";
	public final static WeatherTower _tower = new WeatherTower();
	private final static AircraftFactory factory = AircraftFactory.getInstance();

	public static boolean CreateFlyable(List<String> content) {
		try {
			TimeToRun = Integer.parseInt(content.getFirst());
			content.removeFirst();
			for (String c : content) {
				String[] args = c.split(" ");
				if (args.length != 5 || !AircraftFactory.isValidType(args[TYPE]) || !Coordinates.isValidCoord(args[LONGITUDE], args[LATITUDE], args[HEIGHT])) {
					SimulationIO.OUTPUT.delete();
					return (false);
				} else {
					Coordinates coord = new Coordinates(
							Integer.parseInt(args[LONGITUDE]),
							Integer.parseInt(args[LATITUDE]),
							Integer.parseInt(args[HEIGHT])
					);
					_tower.register(factory.newAircraft(args[TYPE], args[NAME], coord));
				}
			}
			return true;
		} catch (NumberFormatException err) {
			SimulationIO.OUTPUT.delete();
			System.err.println(ERROR);
		}
		return (false);
	}

	public static void Simulation() {
		List<String> content = SimulationIO.OpenFile(SimulationIO.INPUT);
		if (content.isEmpty()) {
			return;
		}

		SimulationIO.CreateOutput();
		CreateFlyable(content);
		while (TimeToRun > 0) {
			TimeToRun--;
			_tower.changeWeather();
		}
	}

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println(ERROR);
		}

		SimulationIO.setInput(args[0]);
		if (!SimulationIO.INPUT.isFile() && !SimulationIO.INPUT.canRead()) {
			System.out.println(ERROR);
			return;
		}

		Simulation();
		SimulationIO.writer.close();
	}
}
