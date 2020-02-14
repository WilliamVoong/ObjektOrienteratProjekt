package src.objektorienterat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameModel implements Serializable,FileHandlerInterface {
	private static final long serialVersionUID = 1L;
	private Mark[][] marks;
	private int markCount;
	private Move lastMove;
	private Playing player1, player2, currentlyPlaying;
	private boolean gameOver;
	private List<ModelListener> listeners;
	
	public GameModel() {
		this.marks = new Mark[3][3];
		this.listeners = new ArrayList<>();
		reset();
		this.gameOver = true;
	}
	
	public void reset() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				this.marks[i][j] = Mark.NULL;
			}
		}
		this.markCount = 0;
		this.lastMove = null;
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
		if(this.gameOver) {
			return;
		}
		this.lastMove = new Move(this.marks[coord.getX()][coord.getY()] = (this.markCount % 2 == 0) ? Mark.X : Mark.O, coord);
		this.markCount++;
		this.currentlyPlaying = (this.currentlyPlaying == player1) ? player2 : player1;
		System.out.println("move made");
		if(this.markCount > 4 && isWinner()) {
			System.out.println("winner");
			this.gameOver = true;
			// NÅGOT HÄNDER NÄR NÅN VINNER
		} else if(this.markCount > 8) {
			System.out.println("tie");
			this.gameOver = true;
			// NÅGOT HÄNDER NÄR DET ÄR OAVGJORT
		}
		notifyListeners();
	}

	private void notifyListeners() {
		System.out.println("notifying MODEL LISTENERS");
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
	
	public void setPlayer1(Playing player1) {
		this.player1 = player1;
	}
	
	public void setPlayer2(Playing player2) {
		this.player2 = player2;
	}
	
	public void gameInit() {
		System.out.println("initialising game");
		Random random = new Random();
		this.currentlyPlaying = (random.nextInt(2) == 0) ? player1 : player2;
		reset();
		this.gameOver = false;
		notifyListeners();
	}
	
	public Playing getCurrentlyPlaying() {
		return this.currentlyPlaying;
	}
	
	/* GAMMAL OFÄRDIG KOD I CONTROLLER:
	public void modelWasUpdated() {
		if(this.gameOver = this.model.isGameOver()) {
			// garbage below is just for testing - will be implemented properly soon(tm)
			String s = (this.model.getMarkCount() % 2 == 0) ? Mark.O.toString() : Mark.X.toString();
			if(this.model.getMarkCount() > 8 && !this.model.isWinner()) {
				s = "No one";
			}
			System.out.println("Game over! The winner is: "+s+"!");
		} else {
			this.currentlyPlaying = (this.currentlyPlaying == player1) ? player2 : player1;
			notifyAI();
		}
	}
	 */

}
