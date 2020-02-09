package src.objektorienterat;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.Serializable;

public class GameView extends DisplayScreen implements Serializable{
	private static final long serialVersionUID = 1L;
	Cell[][] cells = new Cell[3][3];
	private GameController gameController;
	private Cell lastClickedCell;

	public GameView(SwappableScreen layoutManager) {
		super(layoutManager);
		setLayout(new GridLayout(3, 3));
		this.cells = new Cell[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Cell c = this.cells[i][j] = new Cell(new Coordinate(i, j));
				c.addActionListener(
						(ActionEvent e) -> {
							this.lastClickedCell = (Cell)e.getSource();
							this.gameController.viewCellWasClicked();
						});
				add(c);
			}
		}
		reset();
	}
	
	public void setGameController(GameController gameController) {
		this.gameController = gameController;
	}

	public void reset() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				this.cells[i][j].setText("");
			}
		}
		this.lastClickedCell = null;
	}
	
	public void makeMark(Coordinate coord, String s) {
		this.cells[coord.getX()][coord.getY()].setText(s);
		this.gameController.viewStateWasChanged();
	}

	public Cell getLastClickedCell() {
		return this.lastClickedCell;
	}
	
	public Cell getCorrdinate(Coordinate coordinate) {
		return cells[coordinate.getX()][coordinate.getY()];
	}

	public void Change_color(Coordinate coordinate, Color color) {
		cells[coordinate.getX()][coordinate.getY()].setBackground(color);
	}
}
