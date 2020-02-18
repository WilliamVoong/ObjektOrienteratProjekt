package src.objektorienterat;

public class HumanPlayer extends Player implements Playing, ViewListener {
	private GameModel model;
	private GameView view;
	
	public HumanPlayer(Player player, GameModel model, GameView view) {
		super(player.getUsername(), player.getGamesWon(), player.getGamesLost(), player.getGamesDrawn());
		this.model = model;
		this.view = view;
		this.view.addListener(this);
	}
	
	public HumanPlayer(String username, GameModel model, GameView view) {
		super(username);
		this.model = model;
		this.view = view;
		this.view.addListener(this);
	}

	@Override
	public void viewWasUpdated() {
		Coordinate coord = this.view.getLastClickedCell().getCoordinate();
		if(this.model.isLegalMove(this, coord)) {
			this.model.makeMark(coord);
			this.model.changeTurn();
		}
	}
	
}
