package src.objektorienterat;

import java.io.Serializable;

public class HumanPlayer extends Player implements Playing, ViewListener, Serializable {
	private GameModel model;
	private GameView view;

	public HumanPlayer()
	{
		super();
	}
	
	public HumanPlayer(Player player, GameModel model, GameView view) {
		super(player.getUsername(), player.getGamesWon(), player.getGamesLost(), player.getGamesDrawn());
		this.model = model;
		this.view = view;
		this.view.addListener(this);
	}

	@Override
	public void viewWasUpdated() {
		Coordinate coord = this.view.getLastClickedCell().getCoordinate();
		if(this.model.isLegalMove(this, coord)) {
			this.model.makeMark(coord);
		}
	}


	public void UpdateModel(GameModel gameModel)
	{
		this.model=gameModel;
	}

	
}
