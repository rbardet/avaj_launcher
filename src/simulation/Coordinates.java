package simulation;

public class Coordinates {

	private int longitude;
	private int latitute;
	private int height;

	Coordinates(int p_longitude, int p_latitude, int p_height) {
		this.longitude = p_longitude;
		this.latitute = p_latitude;
		this.height = p_height;
		if (this.height > 100) {
			this.height = 100;
		}
	}

	public int getLongitude() {
		return this.longitude;
	}

	public int getLatitute() {
		return this.latitute;
	}

	public int getHeight() {
		return this.height;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public void setLatitute(int latitude) {
		this.latitute = latitude;
	}

	public void setHeight(int height) {
		this.height = height;
		if (this.height > 100) {
			this.height = 100;
		}
	}

	public static boolean isValidCoord(String longitude, String latitude, String height) {
		try {
			int Iheight = Integer.parseInt(height);
			if (Iheight < 0) {
				return false;
			}
			return true;
		} catch (NumberFormatException err) {
			SimulationIO.OUTPUT.delete();
			System.err.println(Main.ERROR);
		}
		return false;
	}
}
