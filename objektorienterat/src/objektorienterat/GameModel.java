package src.objektorienterat;

import java.io.Serializable;

public class GameModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private Mark[][] marks;
	private int markCount;

	public GameModel() {
		this.marks = new Mark[3][3];
		reset();
	}

	private void reset() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				this.marks[i][j] = Mark.NULL;
			}
		}
		this.markCount = 0;
	}

	public void makeMark(Coordinate coord) {
		this.marks[coord.getX()][coord.getY()] = (this.markCount % 2 == 0) ? Mark.X : Mark.O;
		this.markCount++;
	}
	
	public boolean isGameOver() {
		return isWinner() || this.markCount > 8;
	}

	private boolean isWinner() {
		
		// check rows
		for(int i = 0; i < 3; i++) {
			if(	this.marks[i][0].equals(this.marks[i][1])
		    	&&
		    	this.marks[i][1].equals(this.marks[i][2])) 
		    {
				return true;
		   	}
		}
		
		// check columns
		for(int i = 0; i < 3; i++) {
			if(	this.marks[0][i].equals(this.marks[1][i])
		    	&&
		    	this.marks[1][i].equals(this.marks[2][i])) 
		    {
				return true;
		   	}
		}
		
		// check diagonals
		if(	this.marks[0][0].equals(this.marks[1][1])
	        &&
	        this.marks[1][1].equals(this.marks[2][2])
	    	||
	    	this.marks[2][0].equals(this.marks[1][1])
	    	&&
	    	this.marks[1][1].equals(this.marks[0][2]))
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
