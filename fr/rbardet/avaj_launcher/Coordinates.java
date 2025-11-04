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
		return longitude;
	}

	public int getLatitute() {
		return latitute;
	}

	public int getHeight() {
		return height;
	}

}