package src.objektorienterat;

import javax.swing.JButton;

public class Cell extends JButton {
	private static final long serialVersionUID = 1L;
	private Coordinate coordinate;

	public Cell(Coordinate c) {
		super();
		this.coordinate = c;
	}

	public Coordinate getCoordinate() {
		return this.coordinate;
	}
}
