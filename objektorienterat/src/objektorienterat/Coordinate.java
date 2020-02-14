package src.objektorienterat;


import java.io.Serializable;

public class Coordinate implements Serializable {
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
}