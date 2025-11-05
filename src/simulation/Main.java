package simulation;

import aircraft.AircraftFactory;
import aircraft.Coordinates;
import execption.CustomExecption;
import java.util.List;
import weather.WeatherTower;

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

	public static void CreateFlyable(List<String> content) {
		try {
			TimeToRun = Integer.parseInt(content.getFirst());
			content.removeFirst();
			for (String c : content) {
				String[] args = c.split(" ");
				if (args.length != 5 || !AircraftFactory.isValidType(args[TYPE]) || !Coordinates.isValidCoord(args[LONGITUDE], args[LATITUDE], args[HEIGHT])) {
					throw new CustomExecption("Error: Invalid Argument in input file");
				} else {
					Coordinates coord = new Coordinates(
							Integer.parseInt(args[LONGITUDE]),
							Integer.parseInt(args[LATITUDE]),
							Integer.parseInt(args[HEIGHT])
					);
					_tower.register(factory.newAircraft(args[TYPE], args[NAME], coord));
				}
			}
		} catch (NumberFormatException err) {
			SimulationIO.OUTPUT.delete();
		} catch (CustomExecption err) {
			err.printStackTrace();
		}
	}

	public static void Simulation() {
		try {
			List<String> content = SimulationIO.OpenFile(SimulationIO.INPUT);
			if (content.isEmpty()) {
				throw new CustomExecption("Error: Empty input file");
			}

			SimulationIO.CreateOutput();
			CreateFlyable(content);
			while (TimeToRun > 0) {
				TimeToRun--;
				_tower.changeWeather();
			}
		} catch (CustomExecption err) {
			err.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			if (args.length != 1) {
				throw new CustomExecption("Error: need only 1 file as arg");
			}

			SimulationIO.setInput(args[0]);
			if (!SimulationIO.INPUT.isFile() && !SimulationIO.INPUT.canRead()) {
				throw new CustomExecption("Error: not a file or can't read it");
			}

			Simulation();
			SimulationIO.writer.close();
		} catch (CustomExecption err) {
			err.printStackTrace();
		}
	}
}
