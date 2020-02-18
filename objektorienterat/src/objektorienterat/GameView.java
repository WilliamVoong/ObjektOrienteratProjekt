package src.objektorienterat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

public class GameView extends JPanel implements Serializable, FileHandlerInterface, ModelListener {
	private static final long serialVersionUID = 1L;
	private Cell[][] cells = new Cell[3][3];
	private Cell lastClickedCell = null;
	private List<ViewListener> listeners = new ArrayList<>();
	private GameModel model;
	
	public GameView(SwappableScreen screen, GameModel model) {
		super();
		this.model = model;
		this.model.addListener(this);
		setLayout(new GridLayout(3, 3));
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				Cell c = this.cells[i][j] = new Cell(new Coordinate(i, j));
				c.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						lastClickedCell = (Cell)e.getSource();
						notifyListeners();
					}
				});
				add(c);
			}
		}
		setPreferredSize(new Dimension(900, 900));
		reset();
	}

	public void reset() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				this.cells[i][j].setText("");
			}
		}
	}
	
	@Override
	public void modelWasUpdated() {
		Move move = this.model.getLastMove();
		if(move != null) {
			setCellState(move);
		}
	}
	
	private void setCellState(Move move) {
		Mark mark = move.getMark();
		Coordinate coord = move.getCoord();
		this.cells[coord.getX()][coord.getY()].setText(move.getMark().toString());
		if(mark == Mark.X)
			Change_color(coord,new Color(0xCE5F86));
		else if(mark == Mark.O)
			Change_color(coord,new Color(0x80CEB9));
	}
	
	public void fullUpdate() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				Coordinate coord = new Coordinate(i, j);
				setCellState(new Move(this.model.getMark(coord), coord));
			}
		}
	}
	
	public void addListener(ViewListener listener) {
		this.listeners.add(listener);
	}
	
	public void removeListener(ViewListener listener) {
		this.listeners.remove(listener);
	}
	
	private void notifyListeners() {
		for(ViewListener listener : this.listeners) {
			listener.viewWasUpdated();
		}
	}
	
	public Cell getLastClickedCell() {
		return this.lastClickedCell;
	}

	/*
	 * BASHARS SAKER
	 */

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
