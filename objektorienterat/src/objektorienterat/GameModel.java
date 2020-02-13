package src.objektorienterat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private Mark[][] marks;
	private int markCount;
	private Move lastMove;
	private List<ModelListener> listeners;
	
	public GameModel() {
		this.marks = new Mark[3][3];
		this.listeners = new ArrayList<>();
		reset();
	}

	public void reset() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				this.marks[i][j] = Mark.NULL;
			}
		}
		this.markCount = 0;
	}
	
	public void addListener(ModelListener listener) {
		this.listeners.add(listener);
	}
	
	public void removeListener(ModelListener listener) {
		this.listeners.remove(listener);
	}
	
	public Move getLastMove() {
		return this.lastMove;
	}
	
	public void makeMark(Coordinate coord) {
		this.lastMove = new Move(this.marks[coord.getX()][coord.getY()] = (this.markCount % 2 == 0) ? Mark.X : Mark.O, coord);
		this.markCount++;
		notifyListeners();
	}
	
	private void notifyListeners() {
		for(ModelListener listener : listeners) {
			listener.modelWasUpdated();
		}
	}

	public boolean isGameOver() {
		return isWinner() || this.markCount > 8;
	}

	public boolean isWinner() {
		
		// check rows
		for(int i = 0; i < 3; i++) {
			if(	!(this.marks[i][0] == Mark.NULL)
				&&
				this.marks[i][0] == this.marks[i][1]
		    	&&
		    	this.marks[i][1] == this.marks[i][2])
		    {
				return true;
		   	}
		}
		
		// check columns
		for(int i = 0; i < 3; i++) {
			if(	!(this.marks[0][i] == Mark.NULL)
				&&
				this.marks[0][i] == this.marks[1][i]
		    	&&
		    	this.marks[1][i] == this.marks[2][i])
		    {
				return true;
		   	}
		}
		
		// check diagonals
		if(	!(this.marks[1][1] == Mark.NULL)
			&&
			this.marks[0][0] == this.marks[1][1]
	        &&
	        this.marks[1][1] == this.marks[2][2]
	    	||
	    	!(this.marks[1][1] == Mark.NULL)
	    	&&
	    	this.marks[2][0] == this.marks[1][1]
	    	&&
	    	this.marks[1][1] == this.marks[0][2])
	    	{
	        	return true;
	        }

		return false;
	}
	
	public Mark getMark(Coordinate coord) {
		return this.marks[coord.getX()][coord.getY()];
	}
	
	public Mark[][] getMarks() {
		return this.marks;
	}
	
	public int getMarkCount() {
		return this.markCount;
	}
    
}
