package src.objektorienterat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

public class GameView extends DisplayScreen implements Serializable, FileHandlerInterface, ModelListener {
	private static final long serialVersionUID = 1L;
	private Cell[][] cells;
	private GameModel model;
	List<ViewListener> listeners;
	
	public GameView(SwappableScreen screen, GameModel model) {
		super(screen);
		this.model = model;
		this.model.addListener(this);
		this.listeners = new ArrayList<>();
		this.cells = new Cell[3][3];
		setLayout(new GridLayout(3, 3));
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				Cell c = new Cell(new Coordinate(i, j));
				c.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						notifyListeners((Cell)e.getSource());
					}
				});
				this.cells[i][j] = c;
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
		/* BORDE DETTA GÖRAS?
		for(ViewListener vl : listeners) {
			this.listeners.remove(vl);
		}
		*/
	}
	
	@Override
	public void modelWasUpdated() {
		Move m = this.model.getLastMove();
		if(m == null) {
			return;
		}
		Coordinate coord = m.getCoord();
		this.cells[coord.getX()][coord.getY()].setText(m.getMark().toString());
		if(model.getMarkCount()%2 ==0 )
			Change_color(coord,new Color(0xCE5F86));
		else
			Change_color(coord,new Color(0x80CEB9));

	}
	
	public void addListener(ViewListener listener) {
		this.listeners.add(listener);
	}
	
	public void removeListener(ViewListener listener) {
		this.listeners.remove(listener);
	}
	
	private void notifyListeners(Cell clickedCell) {
		for(ViewListener vl : listeners) {
			System.out.println("notifying VIEW listener");
			vl.cellWasClicked(clickedCell);
		}
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
