package src.objektorienterat;

public class Player implements Playing {

	private String username;
	private int gamesPlayed;
	private int gamesWon;
	private int gamesLost;
	private int gamesDrawn;
	
	public Player(String username, int gamesWon, int gamesLost, int gamesDrawn) {
		this.username = username;		
		this.gamesWon = gamesWon;
		this.gamesLost = gamesLost;
		this.gamesDrawn = gamesDrawn;
		this.gamesPlayed = this.gamesWon + this.gamesLost + this.gamesDrawn;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	
	public Player(String username) {
		this(username, 0, 0, 0);
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
	public void makeMove(GameModel model, GameView view) {
		Coordinate coord = view.getLastClickedCell().getCoordinate();
		model.makeMark(coord);
		view.makeMark(coord, model.getMark(coord).toString());
	}

}
