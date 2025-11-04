
public class Coordinates {

	private int longitude;
	private int latitute;
	private int height;

	public Coordinates(int p_longitude, int p_latitude, int p_height) {
		this.longitude = p_longitude;
		this.latitute = p_latitude;
		this.height = p_height;
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

	public static boolean isValidCoord(String longitude, String latitude, String height) {
		try {
			int Iheight = Integer.parseInt(height);
			if (Iheight < 0) {
				return false;
			}
			return true;
		} catch (Exception err) {
			System.err.println(Main.ERROR);
			err.printStackTrace();
		}
		return false;
	}
}
