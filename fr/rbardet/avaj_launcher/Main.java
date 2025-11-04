import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	private final static String FILENAME = "./bin/Simulation.txt";
	private static int timeToRun;
	private final static String[] validType = {"Baloon", "Helicopter", "JetPlane"};
	private final static int TYPE = 0;
	private final static int NAME = 1;
	private final static int LONGITUDE = 2;
	private final static int LATITUDE = 3;
	private final static int HEIGHT = 4;
	private final static File OUTPUT = new File(FILENAME);
	private final static String ERROR = "Invalid scenario";
	private static Tower _tower;
	private final static AircraftFactory factory = AircraftFactory.getInstance();

	public static void CreateOutput() {
		try {
			OUTPUT.delete();
			OUTPUT.createNewFile();
			System.out.println("Simulation file created");
		} catch(IOException err) {
			System.out.println(ERROR);
			err.printStackTrace();
		}
	}

	public static List<String> OpenFile(File _file) {
		try {
			Scanner content = new Scanner(_file);
			List<String> lines = new ArrayList<>();
			while (content.hasNextLine()) {
				lines.add(content.nextLine());
			}
			return lines;
		} catch (IOException err) {
			System.out.println(ERROR);
			err.printStackTrace();
		}
		return null;
	}

	public static boolean isValidType(String type) {
		for (String name : validType) {
			if (name.equals(type)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isValidCoord(String longitude, String latitude, String height) {
		try {
			int Iheight = Integer.parseInt(height);
			if (Iheight < 0) {
				return false;
			}
			return true;
		} catch (Exception err) {
			System.err.println(ERROR);
			err.printStackTrace();
		}
		return false;
	}

	public static boolean CreateFlyable(List<String> content) {
		timeToRun = Integer.parseInt(content.getFirst());
		content.removeFirst();
		for (String c : content) {
			String[] args = c.split(" ");
			if (args.length != 5 || !isValidType(args[TYPE]) || !isValidCoord(args[LONGITUDE], args[LATITUDE], args[HEIGHT])) {
				return (false);
			} else {
				Coordinates coord = new Coordinates (
					Integer.parseInt(args[LONGITUDE]),
					Integer.parseInt(args[LATITUDE]),
					Integer.parseInt(args[HEIGHT])
				);
				_tower.register(factory.newAircraft(args[TYPE], args[NAME], coord));
			}
		}
		return true;
	}

	public static boolean IsValidFile(String arg) {
		final File INPUT = new File(arg);
		if (!INPUT.isFile() && !INPUT.canRead()) {
			return false;
		}
		
		List<String> content = OpenFile(INPUT);
		if (content.isEmpty()) {
			return false;
		}

		CreateOutput();
		if (!CreateFlyable(content)) {
			return false;
		}
		return true;
	}

	public static void Main(String[] args) {
		System.out.println("TESSSST");
		if (args.length < 1 || !IsValidFile(args[0])) {
			System.out.println(ERROR);
		}
	}
}