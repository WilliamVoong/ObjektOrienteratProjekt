package src.objektorienterat;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JPanel;

public class GUI_GAME extends DisplayScreen implements Serializable{
	Cell[][] cells = new Cell[3][3];

	public GUI_GAME(SwappableScreen layoutManager) {
		super(layoutManager);
		setLayout(new GridLayout(3, 3));
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				this.cells[i][j] = new Cell(new Coordinate(i, j));
				this.cells[i][j].setFont(new Font("Calibri", Font.PLAIN, 75));
				this.cells[i][j].setBackground(new Color(0x4988CE));
				this.cells[i][j].setForeground(Color.white);
				add(this.cells[i][j]);
			}
		}
	}

	public void setCellText(Coordinate c, String text) {
		this.cells[c.getX()][c.getY()].setText(text);
	}

	public void addCellListener(Coordinate c, ActionListener cellListener) {
		this.cells[c.getX()][c.getY()].addActionListener(cellListener);
	}
}
