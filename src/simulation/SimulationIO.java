package simulation;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimulationIO {

	private final static String FILENAME = "Simulation.txt";
	public static File INPUT;
	public final static File OUTPUT = new File(FILENAME);
	public static PrintWriter writer;

	public static void setInput(String p_input) {
		INPUT = new File(p_input);
	}

	public static void CreateOutput() {
		try {
			if (OUTPUT.exists()) {
				OUTPUT.delete();
			}

			OUTPUT.createNewFile();
			writer = new PrintWriter(OUTPUT);
		} catch (IOException err) {
			System.out.println(Main.ERROR);
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
			System.out.println(Main.ERROR);
		}
		return null;
	}
}
