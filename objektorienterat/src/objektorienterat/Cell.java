package src.objektorienterat;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;

public class Cell extends JButton implements Serializable {
	private static final long serialVersionUID = 1L;
	private Coordinate coordinate;

	public Cell(String s, Coordinate coordinate) {
		super(s);
		setFont(new Font("Calibri", Font.PLAIN, 75));
		setBackground(new Color(0x4988CE));
		setForeground(Color.white);
		//setForeground(Color.white);
		this.coordinate = coordinate;
	}
	
	public Cell(Coordinate coordinate) {
		this("", coordinate);
	}
	
	public Coordinate getCoordinate() {
		return this.coordinate;	
	}
}
