package src.objektorienterat;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class GameView extends DisplayScreen implements Serializable, ModelListener {
	private static final long serialVersionUID = 1L;
	private Cell[][] cells;
	private GameModel model;
	
	public GameView(SwappableScreen screen, GameModel model) {
		super(screen);
		this.model = model;
		this.model.addListener(this);
		this.cells = new Cell[3][3];
		setLayout(new GridLayout(3, 3));
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				add(this.cells[i][j] = new Cell(new Coordinate(i, j)));
			}
		}
		reset();
	}
	
	public void addCellListeners(ActionListener cellListener) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				this.cells[i][j].addActionListener(cellListener);
			}
		}
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
		Move m = this.model.getLastMove();
		Coordinate coord = m.getCoord();
		this.cells[coord.getX()][coord.getY()].setText(m.getMark().toString());
	}

	public void Change_color(Coordinate coordinate, Color color) {
		cells[coordinate.getX()][coordinate.getY()].setBackground(color);
	}
}
