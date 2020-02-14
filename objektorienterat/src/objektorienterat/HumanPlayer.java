package src.objektorienterat;

public class HumanPlayer extends Player implements Playing, ViewListener {
	private GameModel model;
	
	public HumanPlayer(Player player, GameModel model) {
		super(player.getUsername(), player.getGamesWon(), player.getGamesLost(), player.getGamesDrawn());
		this.model = model;
	}

	@Override
	public void cellWasClicked(Cell clickedCell) {
		if(this.model.getCurrentlyPlaying() == this) {
			this.model.makeMark(clickedCell.getCoordinate());
		}
	}
	
}
