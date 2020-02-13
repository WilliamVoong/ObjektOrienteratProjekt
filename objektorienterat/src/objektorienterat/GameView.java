package src.objektorienterat;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.*;

public class GameView extends DisplayScreen implements Serializable, FileHandlerInterface {
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
		setPreferredSize(new Dimension(900, 900));
	}

	public void setCellText(Coordinate c, String text) {
		cells[c.getX()][c.getY()].setText(text);
	}

	public void addCellListener(Coordinate c, ActionListener cellListener) {
		cells[c.getX()][c.getY()].addActionListener(cellListener);


	}

	public Cell getCorrdinate(Coordinate coordinate) {
		return cells[coordinate.getX()][coordinate.getY()];
	}

	public void Change_color(Coordinate coordinate, Color color) {
		cells[coordinate.getX()][coordinate.getY()].setBackground(color);

	}


	public void blinkButton(Coordinate coordinate) {
		Timer blinkTimer = new Timer(500, new ActionListener() {
			private int count = 0;
			private int maxCount = 4;
			private boolean on = false;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (count >= maxCount) {
					cells[coordinate.getX()][coordinate.getY()].setBackground(new Color(0x4988CE));
					((Timer) e.getSource()).stop();
				} else {
					cells[coordinate.getX()][coordinate.getY()].setBackground(on ? new Color(0x92D12B) : new Color(0x4988CE));
					on = !on;
					count++;
				}
			}


		});
		blinkTimer.start();
	}
}
