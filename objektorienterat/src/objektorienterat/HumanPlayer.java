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

	@Override
	public void viewWasUpdated() {
		if(this.model.getCurrentlyPlaying() == this) {
			this.model.makeMark(this.view.getLastClickedCell().getCoordinate());
		}
	}
	
}
