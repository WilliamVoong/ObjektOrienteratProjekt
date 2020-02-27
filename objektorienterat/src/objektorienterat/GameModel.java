package src.objektorienterat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameModel implements Serializable,FileHandlerInterface {
	private static final long serialVersionUID = 1L;
	private Mark[][] marks = new Mark[3][3];
	private int markCount = 0;
	private Move lastMove = null;
	private Playing player1 = null,
			player2 = null,
			currentlyPlaying = null;
	private boolean gameOver = true;
	private List<ModelListener> listeners = new ArrayList<>();

	public GameModel() {
		reset();
	}

	public void reset() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				this.marks[i][j] = Mark.NULL;
			}
		}
		this.markCount = 0;
		this.lastMove = null;
		this.gameOver = true;
	}

	public void addListener(ModelListener listener) {
		this.listeners.add(listener);
	}

	public void removeListener(ModelListener listener) {
		this.listeners.remove(listener);
	}

	public void removeListeners() {
		for(ModelListener listener : this.listeners) {
			this.listeners.remove(listener);
		}
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
		Sound_effect.playSound("buttonclick.wav");
		if(this.markCount > 4 && isWinner()) {
			System.out.println("Someone won! Let's add a way to make something appropriate happen");
			this.gameOver = true;
			// NÅGOT HÄNDER NÄR NÅN VINNER
		} else if(this.markCount > 8) {
			System.out.println("No one won! Let's add a way to make something appropriate happen");
			this.gameOver = true;
			// NÅGOT HÄNDER NÄR DET ÄR OAVGJORT
		}
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

	public void setMarkCount(int markCount)
	{
		this.markCount=markCount;
	}

	public Move getlastmove()
	{
		return lastMove;
	}

	public void setLastMove(Move lastMove)
	{
		this.lastMove=lastMove;
	}
	public void setMarks(Mark[][] marks) {
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				this.marks[i][j]=marks[i][j];
	}

	public void setPlayers(Playing player1, Playing player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public void gameInit(boolean loadgame) {
		if(loadgame)
		{
			this.currentlyPlaying=player1;
		}
		else
		{
			Random random = new Random();
			this.currentlyPlaying = (random.nextInt(2) == 0) ? player1 : player2;

		}

		this.gameOver = false;
		notifyListeners();
	}

	public void setCurrentlyPlaying(Playing player)
	{
		this.currentlyPlaying=player;

	}

	public Playing getPlayer2() {
		return player2;
	}

	public Playing getCurrentlyPlaying() {
		return this.currentlyPlaying;
	}

	public boolean isLegalMove(Playing moveMaker, Coordinate coord) {
		return this.currentlyPlaying == moveMaker && this.marks[coord.getX()][coord.getY()] == Mark.NULL;
	}

}
