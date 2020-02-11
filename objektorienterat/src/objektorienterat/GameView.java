package src.objektorienterat;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;

import javax.swing.*;
import javax.swing.border.Border;

public class GameView extends DisplayScreen implements Serializable, PropertyChangeListener,FileHandlerInterface {
	Cell[][] cells = new Cell[3][3];
	JLabel label;
	JButton suggest_move;

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

			 label=new JLabel();
			label.setFont(new Font("Calibri", Font.PLAIN, 75));
			label.setForeground(Color.white);
			label.setBounds(100, 100, 50, 70);
			add(label);
			suggest_move=new JButton("Suggest");
			add(suggest_move);
		}

	}

	public void setCellText(Coordinate c, String text) { cells[c.getX()][c.getY()].setText(text);
	}

	public void setCellText(String [][] marks)
	{
		for(int i=0;i<3;i++ )
		{
			for(int j=0;j<3;j++)
			{
				setCellText(new Coordinate(i,j),marks[i][j]);
			}
		}

	}
	public void resetcell() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cells[i][j].setText("");
				Change_color(new Coordinate(i,j),new Color(0x4988CE));

			}

		}
	}

	public void addCellListener(Coordinate c, ActionListener cellListener) {
		cells[c.getX()][c.getY()].addActionListener(cellListener);
	}

	public void blinkButton(Coordinate coordinate)
	{
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
					cells[coordinate.getX()][coordinate.getY()].setBackground( on ? new Color(0x92D12B): new Color(0x4988CE));
					on = !on;
					count++;
				}
			}



		});
		blinkTimer.start();
	}




	public void addSuggestListner(ActionListener actionListener)
	{
		suggest_move.addActionListener(actionListener);
	}
	public Cell getCorrdinate(Coordinate coordinate)
	{
		return cells[coordinate.getX()][coordinate.getY()];
	}

	public void Change_color(Coordinate coordinate, Color color) {
	cells[coordinate.getX()][coordinate.getY()].setBackground(color);
	}

	@Override
	public void propertyChange(PropertyChangeEvent propertyChangeEvent) {

		if(propertyChangeEvent.getPropertyName().equals("second"))
		{
			label.setText(Integer.toString((Integer) propertyChangeEvent.getNewValue()));
		}

		else
		{
			setCellText((Coordinate)propertyChangeEvent.getOldValue(), (String) propertyChangeEvent.getNewValue());
			if(propertyChangeEvent.getNewValue().equals("X"))
				Change_color((Coordinate)propertyChangeEvent.getOldValue(),new Color(0x6CCEAE));
			else
				Change_color((Coordinate)propertyChangeEvent.getOldValue(),new Color(0xC16FCE));
		}

	}
}
