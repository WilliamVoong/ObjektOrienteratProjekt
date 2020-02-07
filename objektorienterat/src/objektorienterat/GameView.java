package src.objektorienterat;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JPanel;

public class GameView extends DisplayScreen implements Serializable{
	Cell[][] cells = new Cell[3][3];

	public GameView(SwappableScreen layoutManager) {
		super(layoutManager);
		setLayout(new GridLayout(3, 3));
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cells[i][j] = new Cell(new Coordinate(i, j));
				cells[i][j].setFont(new Font("Calibri", Font.PLAIN, 75));
				cells[i][j].setBackground(new Color(0x4988CE));
				cells[i][j].setForeground(Color.white);
				add(cells[i][j]);
			}
		}
	}

	public void setCellText(Coordinate c, String text) { cells[c.getX()][c.getY()].setText(text);
	}

	public void addCellListener(Coordinate c, ActionListener cellListener) {
		cells[c.getX()][c.getY()].addActionListener(cellListener);


	}
	public Cell getCorrdinate(Coordinate coordinate)
	{
		return cells[coordinate.getX()][coordinate.getY()];
	}

	public void Change_color(Coordinate coordinate, Color color)
	{
		cells[coordinate.getX()][coordinate.getY()].setBackground(color);

	}
}
