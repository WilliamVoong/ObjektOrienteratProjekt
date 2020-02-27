package src.objektorienterat;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;


public class Player implements ViewListener, Playing , Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private String username;
	private int gamesPlayed;
	private int gamesWon;
	private int gamesLost;
	private int gamesDrawn;
	private GameModel model;
	private GameView view;

	public Player(String username, int gamesWon, int gamesLost, int gamesDrawn) {
		this.username = username;
		this.gamesWon = gamesWon;
		this.gamesLost = gamesLost;
		this.gamesDrawn = gamesDrawn;
		this.gamesPlayed = this.gamesWon + this.gamesLost + this.gamesDrawn;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Player(String username, int gamesWon, int gamesLost, int gamesDrawn, GameModel model, GameView view) {
		this(username, gamesWon, gamesLost, gamesDrawn);
		this.model = model;
		this.view = view;
	}

	public Player(String username) {
		this(username, 0, 0, 0);
	}

	public Player(String username, GameModel model, GameView view) {
		this(username);
		this.model = model;
		this.view = view;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public String getUsername() {
		return this.username;
	}

	public int getGamesPlayed() {
		return this.gamesPlayed;
	}

	public int getGamesWon() {
		return this.gamesWon;
	}

	public int getGamesLost() {
		return this.gamesLost;
	}

	public int getGamesDrawn() {
		return this.gamesDrawn;
	}

	public void incrementGamesWon() {
		this.gamesPlayed++;
		this.gamesWon++;
	}

	public void incrementGamesLost() {
		this.gamesPlayed++;
		this.gamesLost++;
	}

	public void incrementGamesDrawn() {
		this.gamesPlayed++;
		this.gamesDrawn++;
	}

	@Override
	public void viewWasUpdated() {
		makeMove();
	}

	@Override
	public void makeMove() {
		Coordinate coord = this.view.getLastClickedCell().getCoordinate();
		if(this.model.isLegalMove(this, coord)) {
			this.model.makeMark(coord);
		}
	}

	@Override
	public void win() {
		stopListening();
		incrementGamesWon();
	}

	@Override
	public void lose() {
		stopListening();
		incrementGamesLost();
	}

	@Override
	public void draw() {
		stopListening();
		incrementGamesDrawn();
	}

	public void setGameModel(GameModel model) {
		this.model = model;
	}

	public void setGameView(GameView view) {
		this.view = view;
	}

	private Player getSelf() {
		return this;
	}

	private void stopListening() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				view.removeListener(getSelf());
			}
		}, 500);
	}
	
	/*
	 * Gör en djup kopia av spelaren då fälten är av primitiva typer
	 * returnerar en kopia av detta objekt, men om det inte går att klona så returnerar den null
	 */
	public Player clone() 
	{ 
		try {
			return (Player) super.clone(); 
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
			return null; 
		}
	} 
	public void cloneScore(Player p){
	   this.gamesDrawn=p.gamesDrawn;
	   this.gamesLost=p.gamesLost;
	   this.gamesWon=p.gamesWon;
	   this.gamesPlayed=p.gamesPlayed;
    	
    }
	
	public void resetScore() {
		  this.gamesDrawn=0;
		  this.gamesLost=0;
		  this.gamesWon=0;
		  this.gamesPlayed=0;
		
	}
		
}
