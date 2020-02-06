package src.objektorienterat;

import java.util.Comparator;

public class Player {
	private String username;
	private int gamesPlayed;
	private int gamesWon;
	private int gamesLost;
	private int gamesDrawn;
	
	public Player(String username, int gamesPlayed, int gamesWon, int gamesLost, int gamesDrawn) {
		this.username = username;
		this.gamesPlayed = gamesPlayed;
		this.gamesWon = gamesWon;
		this.gamesLost = gamesLost;
		this.gamesDrawn = gamesDrawn;
	}
	
	public Player(String username) {
		this(username, 0, 0, 0, 0);
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

}
